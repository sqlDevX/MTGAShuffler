import java.security.SecureRandom;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Shuffler {
	static List sourceCards;
	static List targetCards;
	static SecureRandom random = new SecureRandom();
	
	static int handSize=10;
	static int maxRun=1000000;
	static int shuffleCount=100;
	
	static double avgPairs=0;
	static double avgTwoPairs=0;
	static double avgTripples=0;
	static double avgQuads=0;
	static double avgFullhouse=0;
	static double avgLands=0;
	
	static double countLand1=0;
	static double countLand2=0;
	static double countLand3=0;
	static double countLand4=0;
	static double countLand5=0;
	static double countLand6=0;
	static double countLand7=0;
	static double countLand8=0;
	static double countLand9=0;
	static double countLand10=0;

	public static void main(String[] args) {
		
		if (args[0]!=null)
			handSize=Integer.parseInt(args[0]);

		if (args[1]!=null)
			maxRun=Integer.parseInt(args[1]);

		if (args[2]!=null)
			shuffleCount=Integer.parseInt(args[2]);

		
		for (int x=1;x<maxRun;x++)
		{
			testrun(x);

			if (x%10000==0)
				printStatus(x);
		}
		
		printStatus(maxRun);

	}

	public static void printStatus(int run)
	{
		System.out.println("\n**********************************");
		System.out.println("progress: "+run+"/"+maxRun);
		System.out.println("pairs : " + avgPairs/run*100);
		System.out.println("tripples : " + avgTripples/run*100);
		System.out.println("quads : " + avgQuads/run*100);
		System.out.println("fullhouse : " + avgFullhouse/run*100);
		System.out.println("2 pairs : " + avgTwoPairs/run*100);
		System.out.println("avgLands : " + avgLands);
		System.out.println("%1 Land : " + countLand1/run*100);
		System.out.println("%2 Land : " + countLand2/run*100);
		System.out.println("%3 Land : " + countLand3/run*100);
		System.out.println("%4 Land : " + countLand4/run*100);
		System.out.println("%5 Land : " + countLand5/run*100);
		System.out.println("%6 Land : " + countLand6/run*100);
		System.out.println("%7 Land : " + countLand7/run*100);
		System.out.println("%8 Land : " + countLand8/run*100);
		System.out.println("%9 Land : " + countLand9/run*100);
		System.out.println("%10 Land : " + countLand10/run*100);
	}
	
	public static void testrun(int run)
	{
		populate();
		for (int x=0;x<shuffleCount;x++)
			randomize();
		
		
		analyze(run);

	}
	
	public static void analyze(int run)
	{
		List drafted=new LinkedList<>();

		for (int x=0;x<handSize;x++)
		{
			drafted.add(sourceCards.get(x));
		}
		
		Collections.sort(drafted);


		/*
		for (int x=0;x<10;x++)
		{
			System.out.println(drafted.get(x));
		}
		*/

		
		int pairs=0;
		int tripples=0;
		int quads=0;
		int lands=0;

		String lastCard="";
		int repeat=0;
		for (int x=0;x<handSize;x++)
		{
			String currentCard=(String) drafted.get(x);
			
			if (currentCard.startsWith("Land"))
				lands++;
			
			if (currentCard.equals(lastCard))
				repeat++;
			else
			{
				switch(repeat)
				{
				case 1:
					pairs++;
					break;
				case 2:
					tripples++;
					break;
				case 3:
					quads++;
					break;
				}
				lastCard=currentCard;
				repeat=0;
				
			}
		}

//		System.out.println("pairs : " + pairs);
//		System.out.println("tripples : " + tripples);
//		System.out.println("quads : " + quads);
		
		if (pairs==1)
		{
			if (tripples>0 || quads>0 )
			{
				avgFullhouse++;
			} else
				avgPairs++;
		}
		
		if (pairs >=2)
		{
			avgTwoPairs++;
		}
		
		if (tripples==1)
			avgTripples++;
		
		if (quads==1)
			avgQuads++;
		
		avgLands=(avgLands*(run-1) + lands)/run;
		
		switch(lands)
		{
		case 1:
			countLand1++;
			break;
		case 2:
			countLand2++;
			break;
		case 3:
			countLand3++;
			break;
		case 4:
			countLand4++;
			break;
		case 5:
			countLand5++;
			break;
		case 6:
			countLand6++;
			break;
		case 7:
			countLand7++;
			break;
		case 8:
			countLand8++;
			break;
		case 9:
			countLand9++;
			break;
		case 10:
			countLand10++;
			break;
		}
	}
	
	public static void draft()
	{
		System.out.println("*****************************");
		System.out.println("drafting 10");
		for (int x=0;x<handSize;x++)
		{
			System.out.println(sourceCards.get(x));
		}
		System.out.println("*****************************");
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
		sourceCards.add("Land Submerged Boneyard");
		sourceCards.add("Land Submerged Boneyard");
		sourceCards.add("Land Submerged Boneyard");
		sourceCards.add("Land Submerged Boneyard");
		sourceCards.add("Land Woodland Stream");
		sourceCards.add("Land Woodland Stream");
		sourceCards.add("Land Woodland Stream");
		sourceCards.add("Land Woodland Stream");
		sourceCards.add("Land Dimir Guildgate");
		sourceCards.add("Land Dimir Guildgate");
		sourceCards.add("Land Dimir Guildgate");
		sourceCards.add("Land Dimir Guildgate");
		sourceCards.add("Land Golgari Guildgate");
		sourceCards.add("Land Golgari Guildgate");
		sourceCards.add("Land Golgari Guildgate");
		sourceCards.add("Land Golgari Guildgate");
		sourceCards.add("Land Glacial Fortress");
		sourceCards.add("Land Glacial Fortress");
		sourceCards.add("Land Glacial Fortress");
		sourceCards.add("Land Glacial Fortress");

		sourceCards.add("Land Sulfur Falls");
		sourceCards.add("Land Sulfur Falls");
		sourceCards.add("Land Sulfur Falls");
		sourceCards.add("Land Sulfur Falls");
		
		sourceCards.add("Land 1");
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
