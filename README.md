# Simple Blog 

This application is created in order to show IntelliJ debugger features

**NOTE:** To show all these features application must be started with **Debug** option instead of **Run** !!!

## Covered features

### Conditional breakpoints

Add breakpoint in `BlogCli` class in following line

```java
action.getCommand().execute(postService, scanner);
```

and set condition to:

```java
Action.EXIT_APPLICATION == action
```

### Running additional code for debugging

Add non-suspending breakpoint in `BlogApplication` class in following line:

```java
blogCli.run();
```

Then add following code in `Evaluate and log` section:

```java
postService.addPost(new com.chrosciu.post.NewPostDto(
    "Debugger sucks",
    "I cannot find any bug in my app, give me something better !")
);
postService.addPost(new com.chrosciu.post.NewPostDto(
    "Sneaky streams",
    "What really happens in this inferno ?")
);
```

### Logging with breakpoints

Add non-suspending breakpoint (lambda only!) in `PostService` class in following line in `searchPosts` method

```java
.filter(post -> post.getTitle().contains(query) || post.getContent().contains(query))
```

Then add following code in `Evaluate and log` section:

```java
String.format("Filtering post: %s with query: %s, result: %b", post, query, post.getTitle().contains(query) || post.getContent().contains(query));
```
### Catching swallowed exceptions

Add exception breakpoint for **caught** `PostException` exception

Then try to add post with title longer than 20 characters to throw such exception

### Altering variables

Add breakpoint in `PostService` class in first line of `getPost` method.

Then alter the value of `postId` variable and see what happens.

Then try to alter the value of `posts` field in the class and see that **final** fields cannot be changed

### Hot swapping methods

Go to `PostService` and find following line in `addPost` method:

```java
nextId = nextId + 1;
```

Replace it with:

```java
nextId = nextId + 2;
```

Then select `Compile And Reload File` option from context menu and wait until class is recompiled and hot swapped.

### Forcing return / throwing exception / dropping frame

Add breakpoint in `PostService` class in first line of `getPost` method.

Go to Frames pane, RMB on top frame and select `Force return` option. Type following code as a return value:

```java
Optional.of(new PostContentDto("Hello"));
```

Then repeat with `Throw exception` option. Type following code as an exception to be thrown:

```java
new PostException("Muahaha !");
```

Then repeat with `Reject frame` option.

NOTE: With `Reject frame` option following restrictions apply:
* any frame can be rejected, not only the top one
* values of params passed to reentered frame cannot be modified

### Debugging streams

Go to the `PostService` class and add breakpoints in following lines in `searchPosts` method

```java
.filter(post -> post.getTitle().contains(query) || post.getContent().contains(query))
    
.map(post -> new ShortPostDto(post.getId(), post.getTitle()))
```

Note that such breakpoints may be set both for lines and lambdas !

### Marking objects

Add breakpoint in any line in `PostService` class. 
Then after hitting it find `PostService` instance in `Variables` pane select `Mark Object...` option from context menu.
Enter `postService` as label name and resume program.

Add breakpoint in any line in `BlogCli` class. 
Then after hitting it check that previously marked `PostService` instance can be accessed in `Variables` pane as `postService_DebugLabel` variable. 



