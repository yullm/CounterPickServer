Meglofriend's Dota 2 Counter Pick Server.

For use, visit: Meglobot.com/CounterPick

The applications enables you to enter a team composition and view which heroes match up the best against the chosen set. With this you are able to see the possible counters to a team based off Advantage percentage, a statistic developed by Dotabuff, and average win rate.

The server uses a combination of jaunt for web scrapping and Jython to access the Dota 2 API through python. The application starts a thread for each connection and deciphers the payload of each connection and responds accordingly. At this point it has two major functions: Return the initial list of all heroes, which contains links to images, their name and primary attribute; Return a list of comparision data for every hero against the given hero, including itself with zeroed values for order consistency. 

As mentioned in the website repository, the system originated as bot function, hence the socketing. Moving forward this would most definitely be changed to a HTTP request system for simplicity.

Check out Meglofriend at www.meglobot.com and www.twitter.com/meglofriend


