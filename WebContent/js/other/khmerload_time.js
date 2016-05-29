// -----------------------------------------------------------
// Update Time
// -----------------------------------------------------------
var timeUpdater = {
    init: function(serverTime) {
        // Calculate the different between server time and client time
        timeUpdater.diff = (new Date()) / 1000 - serverTime;
    },
    
    run: function() {
        // Update the time every 1 minute
        setInterval(timeUpdater.updateTime ,60000);
    },
    
    updateTime: function() {
        // Loop all elapsed times and update it
        $.each($(".elapsedtime") , function(index,value) {
            $(value).text(timeUpdater.getElapsedTime($(value).data('timestamp'), timeUpdater.diff));
        });
    },
    
    getElapsedTime: function (timestamp, diff) {
        // Get Khmer elapsed time with correct adjustment
        return timeUpdater.getKhmerDuration( (new Date()) / 1000 - timestamp - diff);
    },
    
    getKhmerNum: function(num) {
        // Convert Arabic number to Khmer number
        num = num.toString();
        var string = "";
        var ar = ["០","១","២","៣","៤","៥","៦","៧","៨","៩"];

        for (var i = 0; i < num.length; i++) {
            string += ar[num[i]];
        }
        return string;
    },
    
    getKhmerDuration: function (duration) {
        // Get Khmer elapsed time (no adjustment)
        var tmp;
        
        if (duration < 60) {
            // 1 minute if duration lower than 1 min
            tmp = timeUpdater.getKhmerNum(1) + " នាទីមុន";
        } else if(duration < 600){
            // minutes if duration lower than 10 mins
            tmp = timeUpdater.getKhmerNum(parseInt(duration/60)) + " នាទីមុន";
        } else if(duration < 3600){
            // minutes multiple of 5 if duration lower by 1 hours
            tmp = timeUpdater.getKhmerNum(parseInt(duration/300)*5) + " នាទីមុន";
        } else if(duration < 86400){
            // hours if duration lower than a day
            tmp = timeUpdater.getKhmerNum(parseInt(duration/3600)) + " ម៉ោងមុន";
        } else {
            // days
            tmp = timeUpdater.getKhmerNum(parseInt(duration/86400)) + " ថ្ងៃមុន";
        }

        return tmp;
    }
};