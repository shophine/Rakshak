(function () {
    var connection = require('../Configs/dbConfig');
    var config = require('../Configs/config.json');
    var fs = require('fs');
    var request = require('request');

    module.exports.beginTransaction = function (callback) {
        try{
            connection.beginTransaction(function(err){
                callback(err);
            });
        }
        catch(err){
            callback(err);
        }
    };

    module.exports.rollback = function(callback){
        try{
            connection.rollback(function(err){
                callback(err);
            });
        }
        catch(err){
            callback(err);
        }
    };

    module.exports.commit = function(callback){
        try{
            connection.commit(function(err){
                callback(err);
            });
        }
        catch(err){
            callback(err);
        }
    };
    
    module.exports.getPrice = function (data, callback) {
        try{
            var key = "qZbh8IAZGsZ0C6GYXPIqQR9BFftb3yuBDzqOmSzuP/JbmRAPHLezsnU+y9cVCQyCV8OK96zqZi58+z9HykpQ+w==";
            var url = "https://ussouthcentral.services.azureml.net/workspaces/d334764dd9d04c49b66acd96eab0728f/services/3b9071651d184de4a4681ce2ad056943/execute?api-version=2.0&details=true";
            var options = {
                method : 'POST',
                body : data?data:[],
                headers : {
                    'Authorization' : "Bearer "+key,
                    'Content-Type': 'application/json'
                },
                json : true,
                url : url
            };
            request(options,function (err, res, body) {
                if(err){
                    callback(err);
                }
                else{
                    if(res.statusCode !== 200){
                        callback({message:"Error predicting"});
                    }
                    else{
                        callback(null,body);
                    }
                }
            });
        }
        catch(err){
            callback(err);
        }
    }

})();