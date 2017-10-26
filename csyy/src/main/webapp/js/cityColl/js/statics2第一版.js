var timer1=null;
clearInterval(timer1);
timer1 = setInterval(function (){
    var chart1_series = chart1.getSeries();
    for(var i = 0; i<chart1_series.length; i++){
        if(option1.series[i].type == 'bar'){
            option1.series[i].type = 'line';
        } else {
            option1.series[i].type = 'bar';
        }
    }
    chart1.setOption(option1,true);
},3000);

var timer2=null;
clearInterval(timer2);
timer2 = setInterval(function (){
    var chart2_series = chart2.getSeries();
    for(var i = 0; i<chart2_series.length; i++){
        if(option2.series[i].type == 'pie'){
            option2.series[i].type = 'funnel';
        } else {
            option2.series[i].type = 'pie';
        }
    }
    chart2.setOption(option2,true);
},3000);

var timer3=null;
clearInterval(timer3);
timer3 = setInterval(function (){
    var chart3_series = chart3.getSeries();
    for(var i = 0; i<chart3_series.length; i++){
        if(option3.series[i].type == 'bar'){
            option3.series[i].type = 'line';
        } else {
            option3.series[i].type = 'bar';
        }
    }
    chart3.setOption(option3,true);
},3000);

var timer4=null;
clearInterval(timer4);
timer4 = setInterval(function (){
    var chart4_series = chart4.getSeries();
    for(var i = 0; i<chart4_series.length; i++){
        if(option4.series[i].type == 'bar'){
            option4.series[i].type = 'line';
        } else {
            option4.series[i].type = 'bar';
        }
    }
    chart4.setOption(option4,true);
},3000);

var timer5=null;
clearInterval(timer5);
timer5= setInterval(function (){
    var chart5_series = chart5.getSeries();
        if(chart5_series[3].type == 'bar'){
            chart5_series[3].type = 'line';
        } else {
            chart5_series[3].type = 'bar';
        }
    chart5.setSeries(chart5_series,true);
},3000);


