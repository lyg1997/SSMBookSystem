/**
 * Created by Hiseico on 2017/5/3.
 */
//自动判断iframe高度
function changeFrameHeight() {
    var ifm = document.getElementById("iframe_cont");
    ifm.height = document.documentElement.clientHeight;
}

window.onresize = function () {
    changeFrameHeight();
}


var cTime = {
    ctTask: [],
    bind: function (elem, time) {
        this.ctTask.push({elem: elem, time: time});
    },
    start: function () {
        var _this = this;
        setInterval(function () {
            _this.ctTask.forEach(function (value, key) {
                value.time -= 1000;
                var te = new Date(value.time);
                value.elem.innerText = te.getDay() + "天" + te.getHours() + "时" + te.getMinutes() + "分" + te.getSeconds() + "秒";
            });
        }, 1000)
    }
};

//时间戳转换为日期的方法
function getLocalTime(nS) {
    return new Date(parseInt(nS) * 1000).toLocaleString().replace(/:\d{1,2}$/, ' ');
}

function getDateTime(nS) {
    /* var seconds=nS%60;
     var minutes=parseInt(nS/60%60);*/
    var hours = parseInt(nS / 3600 % 24);
    var days = parseInt(nS / 86400);
    return days + '天' + hours + '小时';
}

function goTime() {	// 倒计时跳转处理
    var mt = parseInt(document.getElementById("mytime").innerHTML);
    mt--;	// 时间减少
    if (mt == 0) {	// 进行跳转
        window.location = goUrl;
    } else {
        document.getElementById("mytime").innerHTML = mt;
        setTimeout(goTime, 1000);	// 每一秒触发一次
    }
}



