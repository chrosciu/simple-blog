# Simple Blog 

This application is created in order to show IntelliJ debugger features

## Covered features

### Running additional code for debugging

Add non-suspending breakpoint in `BlogApplication` class in following line:

```java
blogCli.run();
```

Then add following code in `Evaluate and log` section:

```java
postService.addPost(new com.chrosciu.post.transfer.NewPostDto(
    "Debugger sucks",
    "I cannot find any bug in my app, give me something better !")
);
postService.addPost(new com.chrosciu.post.transfer.NewPostDto(
    "Sneaky streams",
    "What really happens in this inferno ?")
);
```

### Logging with breakpoints

Add non-suspending breakpoint (lambda only!) in `PostService` class in following line

```java
.filter(post -> post.getTitle().contains(query) || post.getContent().contains(query))
```

Then add following code in `Evaluate and log` section:

```java
String.format("Filtering post: %s with query: %s, result: %b", post, query, post.getTitle().contains(query) || post.getContent().contains(query));
```

### Forcing return / throwing exception / dropping frame

Add breakpoint in `PostService` class in first line of `getPost` method.

Go to Frames pane, RMB on top frame and select `Force return` option

Then repeat with `Throw exception` option.

Then repeat with `Drop frame` option.

NOTE: With `Drop frame` option following restrictions apply:
* any frame can be dropped, not only the top one
* values of params passed to reentered frame cannot be modified


### Catching swallowed exceptions

Go to the `BlogCli` class and change the catch clause to:

```java
catch (Exception e) {
   //NO-OP    
}
```

Then add exception breakpoint for caught `PostException` exception

### Debugging streams

Go to the `PostService` class and add breakpoints in following lines

```java
.filter(post -> post.getTitle().contains(query) || post.getContent().contains(query))
    
.map(post -> new ShortPostDto(post.getId(), post.getTitle()))
```

Note that such breakpoints may be set both for lines and lambdas !


