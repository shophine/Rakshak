(function(){
    var express = require('express');
    var app = express();
    var connection = require('./server/Configs/dbConfig');
    var config = require('./server/Configs/config.json');
    var port = config.port;
    var cors = require('cors');
    var logger = require('morgan');
    var bodyParser = require('body-parser');
    var mailer = require('./server/Configs/mailConfig');
    var request = require('request');
    var dbHandler = require('./server/Middlewares/dbHandler');

    //-------------------------middlewares----------------------------------//

    app.use(cors());
    app.use(logger('dev'));
    app.use(bodyParser.json({limit: '50mb'}));
    app.use(bodyParser.urlencoded({limit: '50mb', extended: true }));
    app.use(dbHandler(connection));

    var routes = require('./server/index')(app);
    app.listen(port);
    process.on('SIGINT',function () {
        connection.end(function(){
            console.log('App ended and DB connection Closed');
            process.exit(0);
        });
    });
    console.log("Server running on port "+port);
    module.exports = app;
})();