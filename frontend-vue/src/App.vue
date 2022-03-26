<template>
  <div id="app">
    <div id="app-bg">
      <div></div>
      <div></div>
      <div></div>
      <div></div>
    </div>
    <!-- <ChatList>
    </ChatList> -->
    <AndroidPhone id="phone-view"></AndroidPhone>
    <!-- <ServerList>
    </ServerList> -->
  </div>
</template>

<script>
import api from './http/api.js'
import ChatList from './components/chat/ChatListView'
import AndroidPhone from './components/AndroidPhone'
// import ServerList from './components/ServerList'
export default {
  name: 'App',
  components: {
    ChatList,
    AndroidPhone,
    // ServerList
  },
  data() {
    return {
      userId: 666,
      token: '',
    }
  },
  created() {
    api.queryById({ id: 3506 }).then(data => {
      console.log(data);
    })
  }
}
</script>

<style>
html,
body {
  margin: 0;
  padding: 0;  width: 100%;
  height: 100%;
  overflow: hidden;
  position: absolute;
}
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;  width: 100%;
  height: 100%;
  position: absolute;
}
#app-bg {
  position: relative;
  width: 100%;
  height: 100%;
  background: blueviolet;
  display: flex;
}
#app-bg > div {
  position: absolute;width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  bottom: 0;
  right: 0;
}
#app-bg > div:nth-child(1) {
  background: linear-gradient(
    238deg,
    rgb(130, 255, 0) 0%,
    rgb(0, 84, 166) 100%
  );
  animation: move 12s infinite linear;
}

#app-bg > div:nth-child(2) {
  background: linear-gradient(238deg, rgb(33, 200, 69) 0%, rgb(0, 0, 100) 100%);
  mix-blend-mode: overlay;
  animation: move 60s infinite linear;
}
#app-bg > div:nth-child(3) {
  background: radial-gradient(
    100% 85% at 0% 100%,
    rgb(0, 0, 0) 0%,
    rgb(0, 131, 255) 50%,
    rgb(255, 0, 0) 100%
  );
  mix-blend-mode: difference;
  animation: move 60s infinite linear;
}

#app-bg > div:nth-child(4) {
  background: radial-gradient(
    100% 140% at 100% 0%,
    rgb(0, 134, 62) 0%,
    rgb(0, 239, 255) 50%,
    rgb(0, 113, 186) 100%
  );
  mix-blend-mode: overlay;
  animation: move 60s infinite linear;
}

@keyframes move {
  0% {
    filter: unset;
  }

  100% {
    filter: hue-rotate(360deg);
  }
}
#phone-view {
  position: relative;
  margin: -850px 0 0 100px;
}
</style>
