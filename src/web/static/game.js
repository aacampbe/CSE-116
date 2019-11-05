
const tileSize = 30;
const canvas = document.getElementById("canvas");
const context = canvas.getContext("2d");
context.globalCompositeOperation = 'source-over';
const username = "adrian";
const socket = io.connect("https://tictactoe.info/", {transports: ['websocket']});
setupSocket();
function setupSocket() {
    socket.on('gameState', parseGameState);
}
function parseGameState(jsonGameState){
    console.log(jsonGameState)
    const gameState = JSON.parse(jsonGameState);
    for (let player of gameState['players']){
        placeCircle(player['x'], player['y'], player['name'] === socket.id ? '#ffff00' : '#56bcff', 2.0);
        if(player['health'] <= 0){
            placeCircle(player['x'], player['y'], player['name'] === socket.id ? '#ff0000' : '#ff0000', 2.0);
        }
    }
    for(let enemy of gameState['enemies']){
        placeSquare(enemy['x'], enemy['y'], enemy['name'] === socket.id ? '#F0DB4F' : '#EDA895', 2.0)
        if(enemy['health'] <= 0){
            placeSquare(enemy['x'], enemy['y'], enemy['name'] === socket.id ? '#ff0000' : '#ff0000', 2.0)
        }
    }
}
function initializeGame() {
    socket.emit("register", username);

    // TODO: Add any initialization code you'd like to setup your GUI
    // This function is called once when the page loads

}
function placeSquare(x, y, color) {
    context.fillStyle = color;
    context.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
    context.strokeStyle = 'black';
    context.strokeRect(x * tileSize, y * tileSize, tileSize, tileSize);
}
function placeCircle(x, y, color, size) {
    context.fillStyle = color;
    context.beginPath();
    context.arc(x * tileSize,
        y * tileSize,
        size / 10.0 * tileSize,
        0,
        2 * Math.PI);
    context.fill();
    context.strokeStyle = 'black';
    context.stroke();
}

