(function(){
    var responseHandler = require('../Helpers/responseHandler');
    var express = require('express');
    var router = express.Router();
    var commonService = require('../Services/commonService');
    var smsService = require('../Services/smsService');
    var clientController = require('../Controllers/clientController');

    router.get('/',function (req, res) {
        res.send("Hello");
    });

    router.get('/getCentres',function (req, res) {
        clientController.getCentres(req,res);
    });

    router.get('/getCommodities',function (req, res) {
        clientController.getCommodities(req,res);
    });

    router.post('/price',function (req, res) {
        clientController.getPrice(req,res);
    });

    router.get('/region',function (req, res) {
        clientController.getRegion(req,res);
    });

    router.get('/test',function (req, res) {
        smsService.sendSms(12,function (err, data) {
            if(err){
                responseHandler.error(res,err);
            }
            else{
                responseHandler.response(res,data);
            }
        });
    });

    router.get('/location',function (req, res) {
        clientController.getLocation(req,res);
    });

    router.get('/news',function (req, res) {
        clientController.getNews(req,res);
    });

    router.post('/query',function (req, res) {
        clientController.submitQuery(req,res);
    });

    module.exports = router;
})();