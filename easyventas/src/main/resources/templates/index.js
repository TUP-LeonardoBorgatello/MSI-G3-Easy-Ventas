/*

var app = {
    backend: 'http://localhost:8090/api/easyventas',
    table : null,
    init: function() {
        app.initDatatable('#clientes');

        $("#save").click(function(){
            app.save({
                nombre : $('#nombre').val(),
                apellido: $('#apellido').val(),
                domicilio: $('#domicilio').val(),
                documento: $('#documento').val(),
                id_tipo_doc: $('#id_tipo_doc').val(),
                id_ciudad: $('#id_ciudad').val(),
                estado: $('#estado').val(),
                email: $('#email').val()
            });
        });
    },
    initDatatable : function(documento) {
        app.table = $(documento).DataTable({
            ajax : {
                url : app.backend + '/clientes',
                dataSrc : function(json) {
                    return json;
                }
            },
            dom: 'Bfrtip',
            columns : [
                {data : "nombre"},
                {data : "apellido"},
                {data : "domicilio"},
                {data : "documento"},
                {data : "tipoDocumento"},
                {data : "ciudad"},
                {data : "estado"},
                {data : "email"}
            ],
            buttons: [
                {
                    text : 'Editar',
                    action : function(e, dt, node, config) {
                        console.log(e);
                        var data = dt.rows('.table-active').data()[0];
                        app.setDataToModal(data);
                        $('#clienteModal').modal();
                    }
                }
            ]
        });

        $('#clientes tbody').on('click', 'tr', function(){
            if ($(this).hasClass('table-active')) {
                $(this).removeClass('table-active');
            } else {
                app.table.$('tr.table-active').removeClass('table-active');
                $(this).addClass('table-active');
            }
        });
    },
    setDataToModal : function(data) {
        $('#nombre').val(data.nombre);
        $('#apellido').val(data.apellido);
        $('#domicilio').val(data.domicilio);
        $('#documento').val(data.documento);
        $('#id_tipo_doc').val(data.id_tipo_doc);
        $('#id_ciudad').val(data.id_ciudad);
        $('#estado').val(data.estado);
        $('#email').val(data.email);
    },
    save : function(data) {
        $.ajax({
            url: app.backend + '/cliente/update',
            data : JSON.stringify(data),
            method: 'PUT',
            dataType : 'json',
            contentType: "application/json; charset=utf-8",
            success : function(json) {
                $("#msg").text('Se actualizó el cliente correctamente');
                $("#msg").show();
                $('#clienteModal').modal('hide');
                app.table.ajax.reload();
            },
            error : function(error) {

            }
        })
    }
};

$(document).ready(function(){
    app.init();
});
*/
