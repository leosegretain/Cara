var wsocket;

function connect(contratId) {

    wsocket = new WebSocket("wss://localhost:8181/Notif/" + contratId);
    wsocket.onmessage = onMessage;
}

function onMessage(evt) {

    console.log(evt);
    $("#notification").text(evt.data);
    $("#notification").show();
}

$(function () {

    $("#notification").click(function () {

        $("#notification").hide();
    });
});