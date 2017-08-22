package com.zncm.dminter.player

import kotlin.properties.Delegates

class Player {
    private var state: State by Delegates.observable(State.IDLE, { prop, old, new ->
        println("$old -> $new")
        onPlayerStateChangedListener?.onStateChanged(old, new)
    })

    private fun sendCmd(cmd: PlayCmd) {
        when (cmd) {
            is PlayCmd.Play -> {
                println("\nPlay ${cmd.url} from ${cmd.position}ms")
                state = State.PALYING
                doPlay(cmd.url, cmd.position)
            }
            is PlayCmd.Resume -> {
                println("\nResume. ")
                state = State.PALYING
                doResume()
            }
            is PlayCmd.Pause -> {
                println("\nPause. ")
                state = State.PAUSED
                doPause()
            }
            is PlayCmd.Stop -> {
                println("\nStop.")
                state = State.IDLE
                doStop()
            }
            is PlayCmd.Seek -> {
                println("\nSeek to ${cmd.position}ms, state: $state")
            }
        }
    }

    private fun doPlay(url: String, position: Long) {
        TODO("Play function not yet implemented")
    }

    private fun doResume(){

    }

    private fun doPause() {

    }

    private fun doStop() {

    }

    //region api
    interface OnPlayerStateChangedListener {
        fun onStateChanged(oldState: State, new: State)
    }

    var onPlayerStateChangedListener: OnPlayerStateChangedListener? = null

    fun play(url: String, position: Long = 0) {
        sendCmd(PlayCmd.Play(url, position))
    }

    fun resume() {
        sendCmd(PlayCmd.Resume)
    }

    fun pause() {
        sendCmd(PlayCmd.Pause)
    }

    fun stop() {
        sendCmd(PlayCmd.Stop)
    }

    fun seekTo(position: Long) {
        sendCmd(PlayCmd.Seek(position))
    }
    //endregion
}