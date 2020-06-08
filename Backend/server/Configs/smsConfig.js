(function () {
    var nexmo = require('nexmo');

    var Nexmo = new nexmo({
        apiKey: '5ad3acab',
        apiSecret: '8c28fdc4c36bea0b'
    });

    module.exports = Nexmo;

})();