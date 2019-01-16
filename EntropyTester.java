import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;

public class EntropyTester {
	static List sourceCards;
	static List targetCards;
	static SecureRandom random = new SecureRandom();
	static Map<String,String> mapping=new HashMap<String,String>();

	public static void main(String[] args) {
		populate();
		//randomize();
		buildMapping();

		String deckString=buildDeckString();
		
/*		System.out.println(deckString);
		System.out.println(compressedSize(deckString));*/
		
		int compressedSize=0;
		
		for (int x=0;x<1000000000;x++)
		{
			for (int y=0;y<10;y++)
				randomize();
			String deck=buildDeckString();
			compressedSize=compressedSizeDeflate(deck);
			if (compressedSize<50)
			{
				System.out.println(compressedSize+":"+deck +":"+ x);
			}
		}
	}
	
	public static int compressedSizeDeflate(String deck)
	{
		try {
			byte[] input = deck.getBytes("ASCII");
		
			byte[] output = new byte[100];
		     Deflater compresser = new Deflater();
		     compresser.setInput(input);
		     compresser.finish();
		     int compressedDataLength = compresser.deflate(output);
		     compresser.end();
		     
		     return compressedDataLength;
		     
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}


	public static void randomize()
	{
		while (sourceCards.size()>0)
		{
			int randomPos=random.nextInt(sourceCards.size());
			String sourceCard=(String)sourceCards.get(randomPos);
			sourceCards.remove(randomPos);
			targetCards.add(sourceCard);
		}
		
		sourceCards=targetCards;
		targetCards=new LinkedList<String>();
		
		if (sourceCards.size()!=60)
			System.out.println("error after shuffling!");
	}
	
	public static void buildMapping()
	{
		char token='a';
		char landtoken='1';
		for (int pos=0;pos<60;pos++)
		{
			String card=(String) sourceCards.get(pos);
			String key=card;
			
			if (card.startsWith("Land"))
			{
				key=card.substring(4,5);
				if (!mapping.containsKey(key))
				{
					mapping.put(key, ""+landtoken);
					landtoken++;
				}
				if (!mapping.containsKey(card)) {
					mapping.put(card, mapping.get(key));
				}
			} else
			{
				if (!mapping.containsKey(key))
				{
					mapping.put(card, ""+token);
					token++;
				}
			}
		}
	}
	
	public static String buildDeckString()
	{
		StringBuilder builder=new StringBuilder();
				
		for (int pos=0;pos<60;pos++)
		{
			String card=(String) sourceCards.get(pos);
			builder.append(mapping.get(card));
		}

		return builder.toString();
	}
	

	
	public static void populate()
	{
		sourceCards=new LinkedList<String>();
		targetCards=new LinkedList<String>();

		//sourceCards.add("Divination");
		
		sourceCards.add("Divination");
		sourceCards.add("Divination");
		sourceCards.add("Divination");
		sourceCards.add("Opt");
		sourceCards.add("Opt");
		sourceCards.add("Opt");
		sourceCards.add("Opt");
		sourceCards.add("Secrets of the Golden City");
		sourceCards.add("Secrets of the Golden City");
		sourceCards.add("Secrets of the Golden City");
		sourceCards.add("Secrets of the Golden City");
		sourceCards.add("Search for Azcanta");
		sourceCards.add("Search for Azcanta");
		sourceCards.add("Search for Azcanta");
		sourceCards.add("Search for Azcanta");
		sourceCards.add("Chart a Course");
		sourceCards.add("Chart a Course");
		sourceCards.add("Chart a Course");
		sourceCards.add("Chart a Course");
		sourceCards.add("Sift");
		sourceCards.add("Sift");
		sourceCards.add("Sift");
		sourceCards.add("Sift");
		sourceCards.add("Radical Idea");
		sourceCards.add("Radical Idea");
		sourceCards.add("Radical Idea");
		sourceCards.add("Radical Idea");
		sourceCards.add("Elvish Rejuvenator");
		sourceCards.add("Elvish Rejuvenator");
		sourceCards.add("Elvish Rejuvenator");
		sourceCards.add("Elvish Rejuvenator");
		sourceCards.add("Chemister's Insight");
		sourceCards.add("Chemister's Insight");
		sourceCards.add("Chemister's Insight");
		sourceCards.add("Chemister's Insight");
		sourceCards.add("LandZ Submerged Boneyard");
		sourceCards.add("LandZ Submerged Boneyard");
		sourceCards.add("LandZ Submerged Boneyard");
		sourceCards.add("LandZ Submerged Boneyard");
		sourceCards.add("LandZ Woodland Stream");
		sourceCards.add("LandZ Woodland Stream");
		sourceCards.add("LandZ Woodland Stream");
		sourceCards.add("LandZ Woodland Stream");
		sourceCards.add("LandY Dimir Guildgate");
		sourceCards.add("LandY Dimir Guildgate");
		sourceCards.add("LandY Dimir Guildgate");
		sourceCards.add("LandY Dimir Guildgate");
		sourceCards.add("LandY Golgari Guildgate");
		sourceCards.add("LandY Golgari Guildgate");
		sourceCards.add("LandY Golgari Guildgate");
		sourceCards.add("LandY Golgari Guildgate");
		sourceCards.add("LandY Glacial Fortress");
		sourceCards.add("LandY Glacial Fortress");
		sourceCards.add("LandY Glacial Fortress");
		sourceCards.add("LandY Glacial Fortress");

		sourceCards.add("LandX Sulfur Falls");
		sourceCards.add("LandX Sulfur Falls");
		sourceCards.add("LandX Sulfur Falls");
		sourceCards.add("LandX Sulfur Falls");
		
		sourceCards.add("LandX 1");
/*
		sourceCards.add("Spell1");
		sourceCards.add("Spell1");
		sourceCards.add("Spell1");
		sourceCards.add("Spell1");
*/
		
		if (sourceCards.size()!=60)
			System.out.println("error setting up deck");
	}
	
}
