package Ex1;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javafx.scene.paint.Color;

public class FifaWorldCupDataFileManager implements FifaWorldCupData{
	
	private final int TOTAL_COUNT_INDEX = 0;
	private final int TEAM_SIZE = 54; 
	private final int GAME_SIZE = 14; 
	
	private String teamFile;
	private String gameFile;
	
	private int countOfTeam;
	private int countOfGame;
	
	private int indexOfTeam;
	
	private RandomAccessFile teamsStream;
	private RandomAccessFile gamesStream;
	
	public FifaWorldCupDataFileManager(String teams, String games) throws IOException {	
		teamFile = teams;
		gameFile = games;
		indexOfTeam = 0;
		initTeams();
		initGames();
	}		
	private void initTeams() throws IOException {
		//initial of file
		teamsStream = new RandomAccessFile(teamFile, "rw");		
		try 
		{
			countOfTeam = getFileCountValue(teamsStream);	
		}
		catch(EOFException e) 
		{
			countOfTeam = 0;
			setFileCountValue(teamsStream, countOfTeam);
		}
	}
	private void initGames() throws IOException {
		gamesStream = new RandomAccessFile(gameFile, "rw");		
		try 
		{
			countOfGame = getFileCountValue(gamesStream);	
		}
		catch(EOFException e)
		{
			countOfGame = 0;
			setFileCountValue(gamesStream, countOfGame);
		}
	}
	private void setFileCountValue(RandomAccessFile streamer, int value) throws IOException {
		streamer.seek(TOTAL_COUNT_INDEX);
		streamer.writeInt(value);
	}	
	private int getFileCountValue(RandomAccessFile streamer) throws IOException
	{
		streamer.seek(TOTAL_COUNT_INDEX);
		return streamer.readInt();
	}

	@Override
	public void saveTeam(Team team) throws IOException {
		saveTeam(team, countOfTeam);
	}

	@Override
	public void saveTeam(Team team, int index) throws IOException {	
		
		long phisicalIndex = getTeamIndex(index);
		clearSpaceFromFile(phisicalIndex, TEAM_SIZE, teamsStream);
		
		teamsStream.seek(phisicalIndex);
		teamsStream.writeUTF(team.getCountryName());
		
		teamsStream.writeDouble(team.getfirstColor().getRed());
		teamsStream.writeDouble(team.getfirstColor().getGreen());
		teamsStream.writeDouble(team.getfirstColor().getBlue());
		
		teamsStream.writeDouble(team.getsecondaryColor().getRed());
		teamsStream.writeDouble(team.getsecondaryColor().getGreen());
		teamsStream.writeDouble(team.getsecondaryColor().getBlue());
		
		countOfTeam++;
		setFileCountValue(teamsStream, countOfTeam);
	}

	private long getTeamIndex(long index) {
		return index * TEAM_SIZE + Integer.BYTES;
	}	
	private long getGameIndex(long index){
		return index * GAME_SIZE + Integer.BYTES;
	}
	
	private void clearSpaceFromFile(long fromIndex, int size, RandomAccessFile stream) throws IOException {
		if(fromIndex == stream.length())
			return;
		stream.setLength(stream.length() + size);
		
		for(long i = stream.length(); i>= fromIndex; i--)
		{
			stream.seek(i - size);
			byte data = stream.readByte();
			stream.seek(i);
			stream.writeByte(data);
		}
	}

	@Override
	public Team nextTeam() throws IOException {
		indexOfTeam =indexOfTeam == countOfTeam - 1 ? 0 : indexOfTeam + 1;
		return getTeaM(indexOfTeam);
	}

	@Override
	public Team previousTeam() throws IOException {
		Team result = getTeaM(indexOfTeam);
		indexOfTeam =indexOfTeam == 0 ? countOfTeam - 1 : indexOfTeam - 1;
		return result;
	}
	
	private Team getTeaM(int index) throws IOException{			
		teamsStream.seek(getTeamIndex(index));
		String stateName = teamsStream.readUTF();
		Color mainColor = Color.color(teamsStream.readDouble(), teamsStream.readDouble(), teamsStream.readDouble());
		Color secondaryColor = Color.color(teamsStream.readDouble(), teamsStream.readDouble(), teamsStream.readDouble());	
		return new Team(stateName, mainColor, secondaryColor);
	}
	

	@Override
	public void saveGame(Game game) throws IOException {
		saveGame(game, countOfGame);
	}

	@Override
	public void saveGame(Game game, int index) throws IOException {
		long Index = getGameIndex(index);
		clearSpaceFromFile(Index, GAME_SIZE, gamesStream);
		gamesStream.seek(Index);
		gamesStream.writeUTF(game.getHomeTeam());
		gamesStream.writeUTF(game.getGuestTeam());
		gamesStream.writeInt(game.getHomeTeamScore());
		gamesStream.writeInt(game.getGuestTeamScore());
		
		countOfGame++;
		setFileCountValue(gamesStream, countOfGame);		
	}

	
	public Game getGamE(int index) throws IOException {
		gamesStream.seek(getGameIndex(index));		
		String hostingTeam = gamesStream.readUTF();
		String hostedTeam = gamesStream.readUTF();
		int hostingTeamScore = gamesStream.readInt();
		int hostedTeamScore = gamesStream.readInt();
		
		return new Game(hostingTeam, hostedTeam, hostingTeamScore, hostedTeamScore);
		
	}

	@Override
	public int getNumOfTeams() {
		return countOfTeam;
	}

	@Override
	public int getNumOfGames() {
		return countOfGame;
	}
	@Override
	
	public Game getGameAt(int index) throws IOException {
		
		return null;
	}
	

}
