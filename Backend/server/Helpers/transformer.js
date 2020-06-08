(function(){

    var json = require('../Configs/mlAPI.json');
    var moment = require('moment');
    module.exports.constructpricedata = function (body,callback) {
        try{
            var Values = [];
            var dateObj = Date.parse(body.Date);
            dateObj = Math.round(dateObj/86400000);
            console.log(dateObj);
            var value = [dateObj,body.Centre,body.Commodity,body.Price,body.Region,body.Country];
            Values.push(value);
            json.Inputs.input1.Values = Values;
            if(Values.length > 0 && value.length > 0){
                callback(null,json);
            }
            else{
                callback({message:"Error in constructing request"});
            }
        }
        catch(err){
            callback(err);
        }
    };

})();