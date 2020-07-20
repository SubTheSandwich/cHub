package me.sub.cHub;


import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.sub.cHub.Commands.HubCommand;
import me.sub.cHub.Commands.ServerGUICommand;
import me.sub.cHub.Commands.SettingsCommand;
import me.sub.cHub.Commands.StuckCommand;
import me.sub.cHub.Commands.TogglePMCommand;
import me.sub.cHub.Commands.ToggleSoundCommand;
import me.sub.cHub.Commands.messageCommand;
import me.sub.cHub.Commands.replyCommand;
import me.sub.cHub.Events.BlockEvents;
import me.sub.cHub.Events.ChatEvent;
import me.sub.cHub.Events.DamageEvent;
import me.sub.cHub.Events.DoubleJump;
import me.sub.cHub.Events.DoubleJumpFly;
import me.sub.cHub.Events.DropEvent;
import me.sub.cHub.Events.DropPickEvent;
import me.sub.cHub.Events.HealEvent;
import me.sub.cHub.Events.HidePlayerEvents;
import me.sub.cHub.Events.InventoryMoveEvent;
import me.sub.cHub.Events.JoinScoreboardEvent;
import me.sub.cHub.Events.LeaveQueueEvent;
import me.sub.cHub.Events.RidePearl;
import me.sub.cHub.Events.ServerSelectEvents;
import me.sub.cHub.Events.ServerSelectorOpen;
import me.sub.cHub.Events.SettingEvents;
import me.sub.cHub.Events.TeleportEvent;
import me.sub.cHub.Events.TeleportOnSpawn;
import me.sub.cHub.Events.VoidHeightTeleport;
import me.sub.cHub.Events.onJoinItems;
import me.sub.cHub.Events.onJoinMOTD;
import me.sub.cHub.files.HubConfig;
import me.sub.cHub.files.MOTDConfig;
import me.sub.cHub.utils.messageManager;
import me.tigerhix.lib.scoreboard.ScoreboardLib;
import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {
	
	public messageManager mM;
	
	public ArrayList<Player> togglepm_list = new ArrayList<>();
	public ArrayList<Player> togglesound_list = new ArrayList<>();
	public ArrayList<Player> queueserver1_list = new ArrayList<>();
	public ArrayList<Player> queueserver2_list = new ArrayList<>();
	
	@SuppressWarnings("unused")
	public void onEnable () {
		this.saveDefaultConfig();
		this.saveConfig();
		loadCommands();
		getServer().getPluginManager().registerEvents(new onJoinMOTD(this), this);
		getServer().getPluginManager().registerEvents(new RidePearl(this), this);
		getServer().getPluginManager().registerEvents(new DamageEvent(), this);
		getServer().getPluginManager().registerEvents(new TeleportEvent(), this);
		getServer().getPluginManager().registerEvents(new DropEvent(), this);
		getServer().getPluginManager().registerEvents(new onJoinItems(this), this);
		getServer().getPluginManager().registerEvents(new InventoryMoveEvent(), this);
		getServer().getPluginManager().registerEvents(new DropPickEvent(), this);
		getServer().getPluginManager().registerEvents(new ServerSelectEvents(this), this);
		getServer().getPluginManager().registerEvents(new ServerSelectorOpen(), this);
		getServer().getPluginManager().registerEvents(new HidePlayerEvents(), this);
		getServer().getPluginManager().registerEvents(new BlockEvents(), this);
		getServer().getPluginManager().registerEvents(new HealEvent(), this);
		getServer().getPluginManager().registerEvents(new DoubleJump(this), this);
		getServer().getPluginManager().registerEvents(new DoubleJumpFly(this), this);
		getServer().getPluginManager().registerEvents(new LeaveQueueEvent(this), this);
		getServer().getPluginManager().registerEvents(new JoinScoreboardEvent(this), this);
		getServer().getPluginManager().registerEvents(new SettingEvents(), this);
		getServer().getPluginManager().registerEvents(new TeleportOnSpawn(this), this);
		getServer().getPluginManager().registerEvents(new ChatEvent(this), this);
		getServer().getPluginManager().registerEvents(new VoidHeightTeleport(this), this);
		this.getServer().getConsoleSender().sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "-------------------------------");
		this.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "cHub has been enabled!");
		this.getServer().getConsoleSender().sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "-------------------------------");
		ScoreboardLib.setPluginInstance(this);
		
		HubConfig.setup();
		HubConfig.get().addDefault("StuckNotTeleported", "&cYou have not been teleported because the spawn is not set.");
		HubConfig.get().addDefault("ShowAll", "&eYou have &ashown &eall players to yourself.");
		HubConfig.get().addDefault("HideAll", "&eYou have &chidden &eall players to yourself.");
		HubConfig.get().addDefault("ShowAllText", "&aShow Players");
		HubConfig.get().addDefault("HideAllText", "&cHide Players");
		HubConfig.get().addDefault("ServerSelectorText", "&eServer Selector");
		HubConfig.get().addDefault("SettingsText", "&bSettings");
		HubConfig.get().addDefault("LeaveQueueText", "&cLeave Queue");
		HubConfig.get().addDefault("ToggleDirectMessagesTitle", "&eToggle Direct Messages");
		HubConfig.get().addDefault("ToggleDirectMessagesText", "&eToggle your message sounds &aon &eor &coff&e.");
		HubConfig.get().addDefault("ToggleSoundsTitle", "&eToggle Sounds");
		HubConfig.get().addDefault("ToggleSoundsText", "&eToggle your message sounds &aon &eor &coff&e.");
		HubConfig.get().addDefault("SafetyTeleportMessage", "&cYou have been teleported to safety.");
		HubConfig.get().addDefault("HubSetSpawn", "&eSpawn has been set.");
		HubConfig.get().addDefault("HubSetSpawnAlreadySet", "&cThe hub spawn is already set.");
		HubConfig.get().addDefault("NoOneReplyTo", "&cYou have no one to reply to.");
		HubConfig.get().addDefault("TogglePMOn", "&eYou may now &arecieve &edirect messages.");
		HubConfig.get().addDefault("TogglePMOff", "&eYou may now &cno longer recieve &edirect messages.");
		HubConfig.get().addDefault("MessageYourself", "&cYou cannot message yourself.");
		HubConfig.get().options().copyDefaults(true);
		HubConfig.save();
		
		MOTDConfig.setup();
		MOTDConfig.get().addDefault("Line", "&7&m-----------------------");
		MOTDConfig.get().addDefault("Line1", "&eWelcome to the &6&lSpigotMC Network!");
		MOTDConfig.get().addDefault("Line2", " ");
		MOTDConfig.get().addDefault("Line3", "&eTwitter: &f@SpigotMC");
		MOTDConfig.get().addDefault("Line4", "&eDiscord: &fdiscord.io/SpigotMC");
		MOTDConfig.get().addDefault("Line5", "&eStore: &fstore.spigotmc.org");
		MOTDConfig.get().addDefault("Line6", " ");
		MOTDConfig.get().options().copyDefaults(true);
		MOTDConfig.save();
		
		int pluginId = 8245;
        Metrics metrics = new Metrics(this, pluginId);
		
		mM = new messageManager(this);
		
	}
	

	
	
	
	
	public void loadCommands() {
		this.getCommand("hub").setExecutor(new HubCommand(this));
		this.getCommand("stuck").setExecutor(new StuckCommand(this));
		this.getCommand("ServerGUI").setExecutor(new ServerGUICommand(this));
		this.getCommand("msg").setExecutor(new messageCommand(this));
		this.getCommand("reply").setExecutor(new replyCommand(this));
		this.getCommand("togglepm").setExecutor(new TogglePMCommand(this));
		this.getCommand("togglesound").setExecutor(new ToggleSoundCommand(this));
		this.getCommand("settings").setExecutor(new SettingsCommand(this));
	}	
}

