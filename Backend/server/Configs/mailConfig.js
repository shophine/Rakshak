(function () {
    var mailer = require('nodemailer');

    var smtpTransport = mailer.createTransport("SMTP",{
        service: "Gmail",
        auth : {
            user : "chintokankarateindiaofficial@gmail.com",
            pass : "ChintokanKarate2017"
        }
    });

    module.exports = smtpTransport;
})();