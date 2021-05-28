
//Data for both PieChart and BarGraph 1
let myChart1 = document.getElementById("myChart").getContext('2d'); //query the chart that was made on the HTML page

let labels1 = ['Tennis', 'Soccer', 'Basketball', 'Football', 'Lacrosse', 'Track', 'Volleyball'];
let data1 = [10,15,12,3,4,34,22]; //In actual project, values will be the data in the database
let colors1 = ['#49ead7','#49cad3','#d2db4b','#de834e','#d94abc','#d94fdc','#ff0055']; //colors to represent each "slice" of the chart


let chart1 = new Chart(myChart1, { //define properties of chart
    type: 'pie',
    data: {
        labels: labels1,
        datasets: [ {
            data: data1, //also possible to directly place dataset in chart, right here
            backgroundColor: colors1
        }]
    },
    options: {
        title: {
            text: "Percent of People Who Play Each Sport",
            display: true
        }
    }
});


let myChart2 = document.getElementById("myChart2").getContext('2d');

let chart2 = new Chart(myChart2, {
    type: 'bar',
    data: {
        labels: labels1,
        datasets: [ {
            data: data1,
            backgroundColor: colors1
        }]
    },
    options: {
        title: {
            display: true,
            text: "Percent of People Who Play Each Sport"
        },
        legend: {
            display: false
        }
    }
});

//Data for second row of graphs
let myChart3 = document.getElementById("myChart3").getContext('2d');
let myChart4 = document.getElementById("myChart4").getContext('2d');

let labels2 = ['9 years','10 years','11 years','12 years','13 years','14 years','15 years','16 years'];
let data2 = [10,15,32,3,0,17,8,12];
let colors2 = ['#49ead7','#49cad3','#d2db4b','#de834e','#d94abc','#d94fdc','#ff0055','#03e3fc'];


let chart3 = new Chart(myChart3, { //define properties of chart
    type: 'doughnut',
    data: {
        labels: labels2,
        datasets: [ {
            data: data2,
            backgroundColor: colors2
        }]
    },
    options: {
        title: {
            text: "Age Breakdown of Students who filled out forms",
            display: true
        }
    }
});

let chart4 = new Chart(myChart4, { //define properties of chart
    type: 'bar',
    data: {
        labels: labels2,
        datasets: [ {
            data: data2,
            backgroundColor: colors2
        }]
    },
    options: {
        title: {
            text: "Age Breakdown of Students who filled out forms",
            display: true
        },
        legend: {
            display: false
        }
    }
});