const stompClient = new StompJs.Client({
  brokerURL: "ws://localhost:8080/velada2024",
});

stompClient.onConnect = (_) => {
  setConnected(true);
  stompClient.subscribe("/topic/votes", (data) => {
    modificarBarrasDeProgreso(JSON.parse(data.body));
  });
};

stompClient.onWebSocketError = (error) => {
  console.error("Error with websocket", error);
};

stompClient.onStompError = (frame) => {
  console.error("Broker reported error: " + frame.headers["message"]);
  console.error("Additional details: " + frame.body);
};

function setConnected(connected) {
  if (connected) {
    $("#vote-team1").removeClass("disabled");
    $("#vote-team2").removeClass("disabled");
    $("#connecting").hide();
  } else {
    $("#vote-team1").addClass("disabled");
    $("#vote-team2").addClass("disabled");
    $("#connecting").show();
  }
}

function connect() {
  stompClient.activate();
}

function disconnect() {
  stompClient.deactivate();
  setConnected(false);
  console.log("Disconnected");
}

function sendVote(teamId) {
  stompClient.publish({
    destination: "/app/votes",
    body: JSON.stringify({
      matchId: "666201b8a6a0911548cd1a97",
      teamId: teamId,
    }),
  });
}

function modificarBarrasDeProgreso(message) {
  $("#progress-bar-team1")
    .css("width", message.fighter1 + "%")
    .attr("aria-valuenow", message.fighter1);

  $("#progress-bar-team2")
    .css("width", message.fighter2 + "%")
    .attr("aria-valuenow", message.fighter2);
}

$(function () {
  $("form").on("submit", (e) => e.preventDefault());
  $("#vote-team1").click(() =>
    sendVote("f65d4f2a-958b-4d94-9d71-61529c6fa1d6")
  );
  $("#vote-team2").click(() =>
    sendVote("bc544e5d-3139-47c0-92b7-b41e1825b510")
  );
});
