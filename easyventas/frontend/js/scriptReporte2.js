var ctx = document.getElementById('reporte2')
var mychart2 = new Chart(ctx,
    {
        type:'doughnut',
        data:
            {
                datasets:
                    [{
                        backgroundColor: ['#FC0101','#FC6401','#FCE901','#27FC01','#01FCFC','#0177FC','#8A01FC','#01FCA1','#FCB401','#01CBFC','#B8FC01'],
                        label:'productos2',
                        borderColor:['red'],
                        borderWidth: 3
                    }]
            },
        options:
            {
                scales:
                    {
                        yAxis:
                            {
                                beginAtZero:true
                            }
                    }
            }
    })


let endpoint='http://localhost:8080/api/easyventas/reporte2'
fetch(endpoint)
    .then(response => response.json())
    .then(datos => mostrar2(datos))
    .catch(error => console.log(error))

function mostrar2(factura)
{
    factura.forEach(element =>
    {
        mychart2.data['labels'].push(element.fecha)
        mychart2.data['datasets'][0].data.push(element.cantFacturas)
    });

}