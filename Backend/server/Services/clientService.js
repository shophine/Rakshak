(function(){
    var clientDao = require('../Dao/clientDao');
    var commonService = require('../Services/commonService');
    var transformer = require('../Helpers/transformer');

    module.exports.getCentres = function (callback) {
        clientDao.getCentres(callback);
    };

    module.exports.getCommodities = function (callback) {
        clientDao.getCommodities(callback);
    };

    module.exports.getPrice = function (body, callback) {
        transformer.constructpricedata(body,function (err, data) {
            if(err){
                callback(err);
            }
            else{
                commonService.getPrice(data,function (err, data) {
                    callback(err,data);
                });
            }
        });
    };

    module.exports.getLocation = function (callback) {
        clientDao.getLocation(callback);
    };

    module.exports.getRegions = function (callback) {
        clientDao.getRegions(callback);
    };

    module.exports.getNews = function (callback) {
        clientDao.getNews(callback);
    };

    module.exports.submitQuery = function (query, callback) {
        clientDao.submitQuery(query,callback);
    };

})();