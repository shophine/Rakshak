(function () {
    var mysql = require('mysql');
    var config = require('./config.json');
    var db = config.test;

    var connection = mysql.createConnection({
        host : db.host,
        port : db.port,
        user : db.username,
        password : db.password,
        database : db.database,
        multipleStatements : true
    });

    try{
        connection.connect(function(err){
            if(err){
                console.log("DB connection error:"+err.message);
            }
            else{
                console.log("App connected to the DB successfully");
            }
        });
    }
    catch(err){
        console.log("DB connection exception:"+err.message);
    }

    module.exports = connection;

})();