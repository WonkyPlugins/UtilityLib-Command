package com.wonkglorg.utilitylib.command;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class ArgumentTypes{
	private static final ArgumentType<OfflinePlayer> offlinePlayer = new OfflinePlayerArgumentType();
	private static final ArgumentType<Player> player = new PlayerArgumentType();
	
	static class OfflinePlayerArgumentType implements ArgumentType<OfflinePlayer>{
		@Override
		public OfflinePlayer parse(StringReader reader) throws CommandSyntaxException {
			return Bukkit.getOfflinePlayer(reader.readString());
		}
	}
	
	static class PlayerArgumentType implements ArgumentType<Player>{
		@Override
		public Player parse(StringReader reader) throws CommandSyntaxException {
			return Bukkit.getPlayer(reader.readString());
		}
	}
	
	public static ArgumentType<OfflinePlayer> offlinePlayer() {
		return offlinePlayer;
	}
	
	public static ArgumentType<Player> player() {
		return player;
	}
}
