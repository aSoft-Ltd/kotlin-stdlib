module.exports = {
    consumeLive: function(live) {
        console.log("dir:")
        console.dir(live)
        console.log("log:")
        console.log(live)
        console.log("Live value: " + live.value);
    },
    canWatchALive: function(live) {
        console.log("Now watching . . .")
        var count = 0
        live.watch((value)=>{
            console.log(live)
            count++
            console.log("New Count: " + count)
        });

        live.value = 12;
        live.value = 13;
        live.value = 14;
    },

    canPeekALive: function(live) {
        console.log("Now peeking . . .")
        var count = 0
        live.peek((value)=>{
            console.log(live)
            count++
            console.log("New Count: " + count)
        });

        live.value = 12;
        live.value = 13;
        live.value = 14;
   },

   canChangeValueFromJs: function(live) {
        console.log("Changing value")
        live.setValue(444)
   }
}