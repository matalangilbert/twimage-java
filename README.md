This application requires a valid Twitter API key, which can be obtained from https://dev.twitter.com/apps.

Create a file called twitter4j.properties in the root directory of the application and enter the following five lines, replacing the details as appropriate.

```
debug=false
oauth.consumerKey=YOUR_CONSUMER_KEY_HERE
oauth.consumerSecret=YOUR_CONSUMER_SECRET_HERE
oauth.accessToken=YOUR_ACCESS_TOKEN_HERE
oauth.accessTokenSecret=YOUR_ACCESS_TOKEN_SECRET_HERE
```

It also requires a valid Flickr API key, which can be obtained from http://www.flickr.com/services/api/

Create a file called flickrj.properties in the root directory of the application, and enter the following two lines, replacing the details as appropriate.

```
apiKey = YOUR_FLICKR_API_KEY_HERE
secret = YOUR_FLICKR_SECRET_HERE
```