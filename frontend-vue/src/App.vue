<template>
  <div id="app">
    <div class="full-page" style="
  background-image: url(./static/imgs/index-bg.jpg);">
    </div>
    <div class="page-content">
      <div class="page-center-content">
        <div id="search-box">
          <div class="page-title">中华成语</div>
          <div id="search-area">
            <div class="input_area">
              <input id="search_sth" type="text" autofocus="" name="wd" autocomplete="off" placeholder="中华成语俗语一键搜索">
            </div>
            <button class="search_submit" id="search_submit" @click="searchSubmit">搜索</button>
          </div>
        </div>

        <div class="modules">
          <div class="mod_item no-touch">
            <div class="wrap_title" style="background-image: url(./static/imgs/modules-1.png);" @click="selectedModule(1)">
              <span>成语接龙</span>
            </div>
          </div>
          <div class="mod_item no-touch">
            <div class="wrap_title" style="background-image: url(./static/imgs/modules-2.png);" @click="selectedModule(2)">
              <span>成语典故</span>
            </div>
          </div>
          <div class="mod_item no-touch">
            <div class="wrap_title" style="background-image: url(./static/imgs/modules-3.png);" @click="selectedModule(3)">
              <span>成语故事</span>
            </div>
          </div>
          <div class="mod_item no-touch">
            <div class="wrap_title" style="background-image: url(./static/imgs/modules-4.png);" @click="selectedModule(4)">
              <span>虚位以待</span>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- <div id="app-bg">
      <div></div>
      <div></div>
      <div></div>
      <div></div>
    </div> -->
    <!-- <ChatList>
    </ChatList> -->
    <!-- <AndroidPhone id="phone-view"></AndroidPhone> -->
    <!-- <ServerList>
    </ServerList> -->
    <!-- <DrawIdiom></DrawIdiom> -->
    <!-- <IdiomInfo :inputword="word"></IdiomInfo> -->
  </div>
</template>

<script>
import api from './http/api.js'
import AndroidPhone from './components/AndroidPhone'
import ChatList from './components/chat/ChatListView'
import DrawIdiom from './components/idiom/DrawIdiom'
import IdiomInfo from './components/idiom/IdiomInfo'

import { Toast } from 'mint-ui';

export default {
  name: 'App',
  components: {
    ChatList,
    AndroidPhone,
    DrawIdiom,
    IdiomInfo,
  },
  data() {
    return {
      userId: 666,
      token: '',
      word: '不到黄河心不死',
    }
  },
  created() {
    // api.queryById({ id: 3506 }).then(data => {
    //   console.log(data);
    // });

  },
  methods: {
    searchSubmit: function () {
      var keyword = document.querySelector('#search_sth').value;
      if (keyword.length == 0) {
        Toast({
          message: '请输入检索关键字',
          position: 'center',
          duration: 5000
        });
        return;
      }

      Toast({
        message: '检索中' + keyword,
        position: 'center',
        duration: 5000
      });

      api.fuzzyQueryByWord({ word: keyword }).then(data => {
        console.log(data);
        Toast({
          message: '检索到：' + data,
          position: 'center',
          duration: 5000
        });
      });
    },
    selectedModule: function (index) {
      Toast({
        message: `选择${index}`,
        position: 'center',
        duration: 5000
      });

    },
  }
}
</script>

<style scoped>
html,
body {
  margin: 0;
  padding: 0;
  width: 100%;
  height: 100%;
  overflow: hidden;
  position: absolute;
}
button,
input {
  overflow: visible;
}
button,
input,
optgroup,
select,
textarea {
  font-family: sans-serif;
  font-size: 100%;
  line-height: 1.15;
  margin: 0;
}
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  width: 100%;
  min-width: 330px;
  height: 100%;
  position: absolute;
}
.full-page {
  height: 100%;
  width: 100%;
  opacity: 1;

  background-repeat: no-repeat;
  background-position: center;
  background-size: cover;
}
.full-page::before {
  content: "";
  width: 100%;
  height: 100%;
  position: absolute;
  left: 0;
  top: 0;
  background: inherit;
  filter: blur(2px);
  z-index: 2;
}
.page-content {
  height: 100%;
  width: 100%;
  opacity: 1;
  position: absolute;
  top: 0;
  left: 0;

  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;

  z-index: 10;
}
.page-center-content {
  width: 100%;
  height: auto;
  display: block;
  background: transparent;
}
#search-box {
  width: 100%;
  opacity: 0;
  -webkit-transition: opacity 0.5s ease, background 0.5s ease;
  -moz-transition: opacity 0.5s ease, background 0.5s ease;
  -o-transition: opacity 0.5s ease, background 0.5s ease;
  -ms-transition: opacity 0.5s ease, background 0.5s ease;
  transition: opacity 0.5s ease, background 0.5s ease;
  z-index: 98;
  opacity: 1;
}

#search-box .page-title {
  color: #fff;
  font-weight: 400;
  font-size: 2rem;
  letter-spacing: 1.5rem;
  margin-bottom: 10px;
  text-align: center;
}
#search-box #search-area {
  display: -webkit-box;
  display: -moz-box;
  display: -webkit-flex;
  display: -ms-flexbox;
  display: box;
  display: flex;
  -webkit-box-pack: center;
  -moz-box-pack: center;
  -o-box-pack: center;
  -ms-flex-pack: center;
  -webkit-justify-content: center;
  justify-content: center;
  width: 80%;
  margin: 0 auto;
}
#search-box #search-area .input_area {
  position: relative;
  display: flex; /*设为伸缩容器*/
  width: 80%;
  max-width: 600px;
}
#search-box #search-area .input_area #search_sth {
  border-radius: 8px 0 0 8px;
  width: auto;
  flex: 1; /*这里设置为占比1，填充满剩余空间*/
  height: 40px;
  border: 0 solid transparent;
  font-size: 16px;
  outline: 0;
  padding-left: 10px;
  padding-right: 10px;
  -webkit-transition: width 0.3s ease;
  -moz-transition: width 0.3s ease;
  -o-transition: width 0.3s ease;
  -ms-transition: width 0.3s ease;
  transition: width 0.3s ease;
  -webkit-transition: box-shadow 0.3s ease;
  -moz-transition: box-shadow 0.3s ease;
  -o-transition: box-shadow 0.3s ease;
  -ms-transition: box-shadow 0.3s ease;
  transition: box-shadow 0.3s ease;
  border-radius: 8px 0px 0px 8px;
  font-size: 21px;
  text-align: center;
  font-weight: 700;
}
#search-box #search-area .search_submit {
  z-index: 0;
  -webkit-transition: background-color 0.3s ease;
  -moz-transition: background-color 0.3s ease;
  -o-transition: background-color 0.3s ease;
  -ms-transition: background-color 0.3s ease;
  transition: background-color 0.3s ease;
  background-color: rgb(102, 153, 125);
  color: #fff;
  height: 40px;
  border: 0 solid transparent;
  width: 20%;
  max-width: 130px;
  outline: 0;
  font-weight: 700;
  font-size: 21px;
  letter-spacing: 3px;
  text-indent: 3px;
  cursor: pointer;
  padding: 0;
  border-radius: 0 8px 8px 0;
}
.modules {
  z-index: 1;
  display: -webkit-box;
  display: -moz-box;
  display: -webkit-flex;
  display: -ms-flexbox;
  display: box;
  display: flex;
  opacity: 0;
  -webkit-box-pack: center;
  -moz-box-pack: center;
  -o-box-pack: center;
  -ms-flex-pack: center;
  -webkit-justify-content: center;
  justify-content: center;
  -webkit-transition: opacity 0.2s ease;
  -moz-transition: opacity 0.2s ease;
  -o-transition: opacity 0.2s ease;
  -ms-transition: opacity 0.2s ease;
  transition: opacity 0.2s ease;
  -webkit-box-lines: multiple;
  -moz-box-lines: multiple;
  -o-box-lines: multiple;
  -webkit-flex-wrap: wrap;
  -ms-flex-wrap: wrap;
  flex-wrap: wrap;
  opacity: 1;
  width: 85%;
  max-width: 600px;
  margin: 0 auto;
}
.modules .mod_item {
  margin-top: 20px;
  border-radius: 8px;
  -webkit-transition: all 0.2s ease;
  -moz-transition: all 0.2s ease;
  -o-transition: all 0.2s ease;
  -ms-transition: all 0.2s ease;
  transition: all 0.2s ease;
  cursor: pointer;
  -webkit-transition: background-color ease 0.3s;
  -moz-transition: background-color ease 0.3s;
  -o-transition: background-color ease 0.3s;
  -ms-transition: background-color ease 0.3s;
  transition: background-color ease 0.3s;
  display: -webkit-box;
  display: -moz-box;
  display: -webkit-flex;
  display: -ms-flexbox;
  display: box;
  display: flex;
  -webkit-box-orient: vertical;
  -moz-box-orient: vertical;
  -o-box-orient: vertical;
  -webkit-flex-direction: column;
  -ms-flex-direction: column;
  flex-direction: column;
  -webkit-box-align: center;
  -moz-box-align: center;
  -o-box-align: center;
  -ms-flex-align: center;
  -webkit-align-items: center;
  align-items: center;
  -webkit-box-pack: center;
  -moz-box-pack: center;
  -o-box-pack: center;
  -ms-flex-pack: center;
  -webkit-justify-content: center;
  justify-content: center;
  text-align: center;
  width: 50%;
  height: 100px;
}
.modules .mod_item .wrap_title {
  border-radius: 8px;
  padding: 0.5rem 0.8rem;
  width: 80%;
  height: 100%;
  display: -webkit-box;
  display: -moz-box;
  display: -webkit-flex;
  display: -ms-flexbox;
  display: box;
  display: flex;
  -webkit-box-pack: center;
  -moz-box-pack: center;
  -o-box-pack: center;
  -ms-flex-pack: center;
  -webkit-justify-content: center;
  justify-content: center;
  -webkit-box-align: center;
  -moz-box-align: center;
  -o-box-align: center;
  -ms-flex-align: center;
  -webkit-align-items: center;
  align-items: center;
  margin: 0 30px;

  background-repeat: no-repeat;
  background-position: center;
  background-color: #fff;
}
.modules .mod_item .wrap_title span {
  color: rgb(199 38 97 / 90%);
  text-shadow: 5px 5px 5px #464646;
  font-size: 35px;
  font-weight: 700;
  letter-spacing: 0.6rem;
}

@media screen and (max-width: 540px) {
  .modules .mod_item .wrap_title span {
    font-size: 30px;
  }
}
@media screen and (max-width: 475px) {
  .modules .mod_item .wrap_title span {
    font-size: 25px;
  }
}
@media screen and (max-width: 410px) {
  .modules .mod_item .wrap_title span {
    font-size: 25px;
    max-width: 6ch;
  }
}

/* #app-bg {
  position: relative;
  width: 100%; 
  height: 100%;
  background: blueviolet;
  display: flex;
}
#app-bg > div {
  position: absolute;
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  bottom: 0;
  right: 0;
}
#app-bg > div:nth-child(1) {
  background: linear-gradient(
    238deg,
    rgb(250, 250, 249) 0%,
    rgb(12, 12, 12) 100%
  );
  animation: move 12s infinite linear;
}

#app-bg > div:nth-child(2) {
  background: linear-gradient(
    238deg,
    rgb(173, 229, 247) 0%,
    rgb(65, 65, 158) 100%
  );
  mix-blend-mode: overlay;
  animation: move 60s infinite linear;
}
#app-bg > div:nth-child(3) {
  background: radial-gradient(
    100% 85% at 0% 100%,
    rgb(0, 0, 0) 0%,
    rgb(132, 191, 247) 50%,
    rgb(250, 91, 91) 100%
  );
  mix-blend-mode: difference;
  animation: move 60s infinite linear;
}

#app-bg > div:nth-child(4) {
  background: radial-gradient(
    100% 140% at 100% 0%,
    rgb(243, 137, 173) 0%,
    rgb(86, 153, 158) 50%,
    rgb(13, 13, 14) 100%
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
} */
#phone-view {
  position: relative;
  margin: -850px 0 0 100px;
}
</style>
