(function () {
    var nexmo = require('../Configs/smsConfig');

    var from = 'Nexmo';
    var to = '917639126080';
    module.exports.sendSms = function (val,callback) {
        try{
            var text = "Predicted yield for paddy is "+val+" INR/kg";
            nexmo.message.sendSms(from,to,text,function (err, data) {
                callback(err,data);
            });
        }
        catch(err){
            callback(err);
        }
    };

})();