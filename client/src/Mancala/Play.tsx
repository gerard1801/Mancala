import React from "react";
import type { GameState } from "../gameState";
import "./Play.css";

type PlayProps = {
    gameState: GameState;
    setGameState(newGameState: GameState): void;
}

export function Play({ gameState, setGameState }: PlayProps) {
    let player1Int = 0;
    let player2Int = 1;

    let getButtonsPlayer1= () => {
        const array = [0,1,2,3,4,5,6];
        return array.map((number) => {
            return <button id={"p1Button"+number} onClick={(e) => tryPitPlay(e, gameState.players[player1Int].pits[number].index)} disabled={number>5}>index {gameState.players[player1Int].pits[number].index} stones {gameState.players[player1Int].pits[number].nrOfStones}</button>
        })
    }

    let getButtonsPlayer2 = () => {
        const array = [6,5,4,3,2,1,0];
        return array.map((number) => {
            return <button id={"p2Button"+number} onClick={(e) => tryPitPlay(e, gameState.players[player2Int].pits[number].index)} disabled={number>5}>index {gameState.players[player2Int].pits[number].index} stones {gameState.players[player2Int].pits[number].nrOfStones}</button>
        })
    }
    async function tryPitPlay(e: React.FormEvent, pitIndex) {
        e.preventDefault();
        try {
            const response = await fetch('mancala/api/play', {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ pitIndex : pitIndex})
            });

            if (response.ok) {
                const gameState = await response.json();
                setGameState(gameState);
            } else {
                console.error(response.statusText);
            }
        } catch (error) {
            console.error(error.toString());
        }
    }
    return (
        <div>
            <p>{gameState.players[player1Int].name} vs {gameState.players[player2Int].name}</p>
            <div id={"Board"}>
                {getButtonsPlayer2()}
                {getButtonsPlayer1()}
            </div>
        </div>

    )
}