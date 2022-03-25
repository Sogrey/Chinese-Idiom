<template>
  <div id="app">
    <!-- <ChatList>
    </ChatList> -->
    <AndroidPhone></AndroidPhone>
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
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
