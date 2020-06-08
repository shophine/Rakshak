(function(){
    var connection = require('../Configs/dbConfig');

    module.exports.getCentres = function (callback) {
        try{
            var query = "SELECT * from centres";
            connection.query(query,function(err,data){
                callback(err,data);
            });
        }
        catch(err){
            callback(err);
        }
    };

    module.exports.getCommodities = function (callback) {
        try{
            var query = "SELECT * from commodities";
            connection.query(query,function (err, data) {
                callback(err,data);
            });
        }
        catch(err){
            callback(err);
        }
    };

    module.exports.getLocation = function (callback) {
        try{
            var query = "SELECT * from centr";
            connection.query(query,function (err, data) {
                callback(err,data);
            });
        }
        catch(err){
            callback(err);
        }
    };

    module.exports.getRegions = function (callback) {
        try{
            var query = "SELECT * from regions";
            connection.query(query,function (err, data) {
                callback(err,data);
            });
        }
        catch(err){
            callback(err);
        }
    };

    module.exports.getNews = function (callback) {
        try{
            var query = "SELECT * from news";
            connection.query(query,function (err, data) {
                callback(err,data);
            });
        }
        catch(err){
            callback(err);
        }
    };

    module.exports.submitQuery = function (quer, callback) {
        try{
            var query = "INSERT into queries set ?";
            connection.query(query,[quer],function (err, data) {
                callback(err,data);
            });
        }
        catch(err){
            callback(err);
        }
    }

})();