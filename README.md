# MTGAShuffler
POC of a Statistics-Sample-Tool for Magic the Gathering

usage:

java.exe -jar shuffler.jar handSize maxRun shuffleCount

handSize = Number of cards to draw from the 60 Cards Test-Deck

maxRun = Number of iterations/samples to produce

shuffleCount = shuffle the Deck x times using "https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle" like method

Example:
java -jar shuffler.jar 7 100000 200

Output:<br>
progress: 100000/100000<br>
pairs : 46.73<br>
tripples : 4.2<br>
quads : 0.055<br>
fullhouse : 0.795<br>
2 pairs : 10.965<br>
avgLands : 2.9167791677916814<br>
%1 Land : 10.477<br>
%2 Land : 25.264999999999997<br>
%3 Land : 31.258000000000003<br>
%4 Land : 21.335<br>
%5 Land : 8.266<br>
%6 Land : 1.5779999999999998<br>
%7 Land : 0.108<br>
%8 Land : 0.0<br>
%9 Land : 0.0<br>
%10 Land : 0.0<br>

-> so you have got an about 46% chance drafting a pair in this deck with you opening hand


The "cards" in this Test-Deck are (better readable in the Shuffler.java at the bottom!):
Divination
Divination
Divination
Opt
Opt
Opt
Opt
Secrets of the Golden City
Secrets of the Golden City
Secrets of the Golden City
Secrets of the Golden City
Search for Azcanta
Search for Azcanta
Search for Azcanta
Search for Azcanta
Chart a Course
Chart a Course
Chart a Course
Chart a Course
Sift
Sift
Sift
Sift
Radical Idea
Radical Idea
Radical Idea
Radical Idea
Elvish Rejuvenator
Elvish Rejuvenator
Elvish Rejuvenator
Elvish Rejuvenator
Chemister's Insight
Chemister's Insight
Chemister's Insight
Chemister's Insight
Land Submerged Boneyard
Land Submerged Boneyard
Land Submerged Boneyard
Land Submerged Boneyard
Land Woodland Stream
Land Woodland Stream
Land Woodland Stream
Land Woodland Stream
Land Dimir Guildgate
Land Dimir Guildgate
Land Dimir Guildgate
Land Dimir Guildgate
Land Golgari Guildgate
Land Golgari Guildgate
Land Golgari Guildgate
Land Golgari Guildgate
Land Glacial Fortress
Land Glacial Fortress
Land Glacial Fortress
Land Glacial Fortress
Land Sulfur Falls
Land Sulfur Falls
Land Sulfur Falls
Land Sulfur Falls
Land 1
