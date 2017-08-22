package com.zncm.dminter.player
sealed class PlayCmd{
    class Play(var url:String,var position:Long=0):PlayCmd()
    class Seek(var position: Long):PlayCmd()
    object Pause:PlayCmd()
    object Resume:PlayCmd()
    object Stop:PlayCmd()
}
