# Entropy-Tester
This is a small POC of a Map-Reduce Entropy-Testing algorithm. First a given deck ist assigned a..z for each different spell and 1..9 for each different land. The deck is shuffled, a deckstring is built:
degb1afh22deb23232ggi3cc22chhceiddg1i3fie1f2b1111hafa222213b

this string is tested for repeatin patterns by simply "deflating" it. if the compressed size is below a certain threshold the deck is considered not "shuffled enough", output is generated

compressed_size:deckstring:iteration
49:fg2e1111ibf2gec2icdhfi3cbgadeia2b212122e3hdhh3ca3131gdfb2222:29907
49:2d1h3bceh21iec2cgbg2e2a2a2hg321de1111322ad2b1if3f3fgihdb2cif:104759
49:degb1afh22deb23232ggi3cc22chhceiddg1i3fie1f2b1111hafa222213b:123354
49:2d211fcf1fc2h2h2eeiccgagg1fihdihbe1b2ea1b2a1222db31g323323di:398373
49:2abed1ii2hbbc33333ahdg22f1c21gi2eedf2gfg2i2a2hfchec11111b2d2:474572
49:3bfh11113b2f2f21212cah22ifc2ga2gcci2db31ahideee2idd33gg12hbe:692305
49:22ehf3ahg2ac2ebghd33iif1111eg2ccigbfh12i2222d3ec231d1d1fa2bb:1169641
49:1ceafddhf2fch11112h32323bb3iehea2cbeg3bcfid21d2g2g2ia121ig22:1330220
49:2giaccbf2222ihh1f11b1df2ge3aib232321212g1eehcgdbc3iddah312ef:1333876


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
