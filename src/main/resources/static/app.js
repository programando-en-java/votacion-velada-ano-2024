const stompClient = new StompJs.Client({
  brokerURL: "ws://localhost:8080/gs-guide-websocket",
});

stompClient.onConnect = (frame) => {
  setConnected(true);
  console.log("Connected: " + frame);
  stompClient.subscribe("/topic/greetings", (greeting) => {
    showGreeting(JSON.parse(greeting.body));
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
  $("#connect").prop("disabled", connected);
  $("#disconnect").prop("disabled", !connected);
  if (connected) {
    $("#conversation").show();
  } else {
    $("#conversation").hide();
  }
  $("#greetings").html("");
}

function connect() {
  stompClient.activate();
}

function disconnect() {
  stompClient.deactivate();
  setConnected(false);
  console.log("Disconnected");
}

function sendName(teamId) {
  stompClient.publish({
    destination: "/app/hello",
    body: JSON.stringify({ teamId: teamId }),
  });
}

function showGreeting(message) {
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
    sendName("f65d4f2a-958b-4d94-9d71-61529c6fa1d6")
  );
  $("#vote-team2").click(() =>
    sendName("bc544e5d-3139-47c0-92b7-b41e1825b510")
  );
});
