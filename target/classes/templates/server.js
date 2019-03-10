var express = require('express');
var app = express();
var server = require('http').createServer(app); // a protocol used to transfer data over the internet
var io = require('socket.io').listen(server);
users = [];
connections = [];

server.listen(process.env.PORT || 3000);
console.log('Server running....');

app.get('/', function (req, res) {
    res.sendFile(__dirname + '/index.html')
});


io.sockets.on('connection', function(socket){   //open a connection, put events we need to emit in the on method
    connections.push(socket);                          // add the socket for use
    console.log('Connected: %s sockets connected', connections.length);  // when someone opens a webpage this code will execute

    // Disconnect
    socket.on('disconnect', function (data) {  // When someone closes a webpage, this code will be executed
    // // username form
    // users.splice(users.indexOf(socket.username),1);  // The splice() method adds/removes items to/from an array, and returns the removed item(s).Note: This method changes the original array.
    // updateUsernames();
        connections.splice(connections.indexOf(socket), 1);
        console.log('Disconnected: %s sockets connected', connections.length); // how many are still connected
    }); // end sockets on

    // Send message
    socket.on('send message', function (data) {
        io.sockets.emit('new message',{msg: data, user: socket.username});
    });

    // // new username
    // socket.on('new user', function(data, callback){ // event that runs when a new username is created and Login button is pressed
    //     callback(true);
    //     socket.username = data;
    //     users.push(socket.username);
    //     updateUsernames();
    // });

    // // username form
    // function updateUsernames(){
    //     io.sockets.emit('get users', users);
    // }

});