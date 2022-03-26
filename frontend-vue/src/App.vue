<template>
  <div id="app">
    <div id="app-bg"> </div>
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
  padding: 0;
  overflow: hidden;
}
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}
#app-bg {
  position: absolute;
  width: 100%;
  height: 100%;
  background: blueviolet;
  background: linear-gradient(238deg, rgb(33, 200, 69) 0%, rgb(0, 0, 100) 100%);
  mix-blend-mode: overlay;
}
#phone-view {
  position: absolute;
  margin: 100px 0 0 100px;
}
</style>
