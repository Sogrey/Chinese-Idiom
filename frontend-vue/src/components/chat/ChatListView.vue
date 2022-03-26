<template>
  <div>
    <section class="chatlist" :class="showSelBox>0?'chatlist-bottom-collapse':'chatlist-bottom'">
      <mt-loadmore :top-method="loadTop" top-pull-text="加载更多" top-drop-text="释放加载" @top-status-change="handleTopChange" ref="loadmore">
        <ul>
          <li v-if="!isInitConfig">
            <div class="chat-user"><img src="../../assets/logo.png"></div>
            <div class="time"><cite>智多星<i>2022</i></cite></div>
            <div class="chat-text">
              欢迎挑战成语接龙，<br>先选个难度等级吧！<a class="link" v-on:click.stop="setConfig">开始吧</a>
            </div>
          </li>
          <template v-for="item in records">
            <li class="chat-mine" v-if="item.type==1">
              <div class="chat-user"><img src="../../assets/logo.png"></div>
              <div class="time"><cite><i>{{item.time}}</i>{{item.name}}</cite></div>
              <div class="chat-text" v-html="replaceFace(item.content)"></div>
            </li>
            <li v-if="item.type==2">
              <div class="chat-user"><img src="https://sogrey.top/img/Sogrey.png"></div>
              <div class="time"><cite>{{item.name}}<i>{{item.time}}</i></cite></div>
              <div class="chat-text" v-html="replaceFace(item.content)"></div>
            </li>
          </template>
        </ul>
      </mt-loadmore>
    </section>

    <!-- <section class="foot">
      <mt-field id="txtContent" placeholder="请输入消息" class="con" v-model="content"></mt-field>
      <span class="btn-face" v-on:click="showSelBox=showSelBox==1?0:1"><i class="fa fa-smile-o" aria-hidden="true"></i></span>
      <span class="btn-plus" v-on:click="showSelBox=showSelBox==2?0:2"><i class="fa" aria-hidden="true" :class="showSelBox==2?'fa-minus-circle':'fa-plus-circle'"></i></span>
      <span class="btn btn-send" v-on:click="sendMsg">发送</span>
      <section class="selbox" :class="showSelBox>0?'show':'hide'">
        <section v-show="showSelBox==1" class="face-box">
          <mt-swipe :auto="0" :continuous="false">
            <mt-swipe-item v-for="n in Math.ceil(EXPS.length/18)">
              <li v-for="(item, index) in getEXP(n,18)">
                <img :src="'static/emotion/'+item.file" alt="" :data="item.code" v-on:click="content+=item.code">
              </li>
            </mt-swipe-item>
          </mt-swipe>
        </section>
        <div v-show="showSelBox==2">{{selOther}}</div>
      </section> 
    </section>-->

  </div>
</template>
<script>
import util from '../../common/utils.js'

export default {
  name: 'chatlist',
  data() {
    return {
      showSelBox: 0, // 0隐藏 1显示表情 2显示其他
      selFace: '表情',
      selOther: '其他功能',
      content: '',
      topStatus: '',
      isInitConfig: false,
      //聊天记录
      records: [{
        type: 2,
        time: util.formatDate.format(new Date(), 'yyyy-MM-dd hh:mm:ss'),
        name: '智多星',
        content: '你好呀'
      }, {
        type: 1,
        time: util.formatDate.format(new Date(), 'yyyy-MM-dd hh:mm:ss'),
        name: '游客',
        content: '你好！'
      },{
        type: 2,
        time: util.formatDate.format(new Date(), 'yyyy-MM-dd hh:mm:ss'),
        name: '智多星',
        content: '你好呀'
      }, {
        type: 1,
        time: util.formatDate.format(new Date(), 'yyyy-MM-dd hh:mm:ss'),
        name: '游客',
        content: '你好！'
      },{
        type: 2,
        time: util.formatDate.format(new Date(), 'yyyy-MM-dd hh:mm:ss'),
        name: '智多星',
        content: '你好呀'
      }, {
        type: 1,
        time: util.formatDate.format(new Date(), 'yyyy-MM-dd hh:mm:ss'),
        name: '游客',
        content: '你好！'
      },{
        type: 2,
        time: util.formatDate.format(new Date(), 'yyyy-MM-dd hh:mm:ss'),
        name: '智多星',
        content: '你好呀'
      }, {
        type: 1,
        time: util.formatDate.format(new Date(), 'yyyy-MM-dd hh:mm:ss'),
        name: '游客',
        content: '你好！'
      },{
        type: 2,
        time: util.formatDate.format(new Date(), 'yyyy-MM-dd hh:mm:ss'),
        name: '智多星',
        content: '你好呀'
      }, {
        type: 1,
        time: util.formatDate.format(new Date(), 'yyyy-MM-dd hh:mm:ss'),
        name: '游客',
        content: '你好！'
      },{
        type: 2,
        time: util.formatDate.format(new Date(), 'yyyy-MM-dd hh:mm:ss'),
        name: '智多星',
        content: '你好呀'
      }, {
        type: 1,
        time: util.formatDate.format(new Date(), 'yyyy-MM-dd hh:mm:ss'),
        name: '游客',
        content: '你好！'
      },{
        type: 2,
        time: util.formatDate.format(new Date(), 'yyyy-MM-dd hh:mm:ss'),
        name: '智多星',
        content: '你好呀'
      }, {
        type: 1,
        time: util.formatDate.format(new Date(), 'yyyy-MM-dd hh:mm:ss'),
        name: '游客',
        content: '你好！'
      },{
        type: 2,
        time: util.formatDate.format(new Date(), 'yyyy-MM-dd hh:mm:ss'),
        name: '智多星',
        content: '你好呀'
      }, {
        type: 1,
        time: util.formatDate.format(new Date(), 'yyyy-MM-dd hh:mm:ss'),
        name: '游客',
        content: '你好！'
      },{
        type: 2,
        time: util.formatDate.format(new Date(), 'yyyy-MM-dd hh:mm:ss'),
        name: '智多星',
        content: '你好呀'
      }, {
        type: 1,
        time: util.formatDate.format(new Date(), 'yyyy-MM-dd hh:mm:ss'),
        name: '游客',
        content: '你好！'
      },],
    }
  },
  methods: {
    //聚焦输入框
    focusTxtContent: function () {
      //   document.querySelector("#txtContent input").focus();
    },
    //滚动条滚动到底部
    scrollToBottom: function () {
      setTimeout(function () {
        var chatlist = document.getElementsByClassName('chatlist')[0];
        chatlist.scrollTop = chatlist.scrollHeight;
      }, 100);
    },//替换表情代码
    replaceFace: function (con) {
      var _this = this;
      // var exps=this.EXPS;
      // for(var i=0;i<exps.length;i++){
      //     //con = con.replace(new RegExp(exps[i].code,'g'), '<img src="static/emotion/' + exps[i].file +'"  alt="" />');
      //     con = con.replace(exps[i].reg, '<img src="static/emotion/' + exps[i].file +'"  alt="" />');
      // }
      return con;
    },
    setConfig() {
      console.log('asdf');
      this.isInitConfig = true;
    },
    handleTopChange(status) {
      this.topStatus = status;
    },
    loadTop(id) {
      var _this = this;
      setTimeout(() => {
        var chatlist = document.getElementsByClassName('chatlist')[0];
        var oldHeight = chatlist.scrollHeight;

        // _this.records.unshift({
        //   type: 1,
        //   time: util.formatDate.format(new Date(), 'yyyy-MM-dd hh:mm:ss'),
        //   name: '游客',
        //   content: '你好！13213'
        // }, {
        //   type: 2,
        //   time: util.formatDate.format(new Date(), 'yyyy-MM-dd hh:mm:ss'),
        //   name: '客户MM',
        //   content: '欢迎欢迎━(*｀∀´*)ノ亻!'
        // });

        setTimeout(function () {
          var newHeight = chatlist.scrollHeight;
          chatlist.scrollTop = newHeight - oldHeight;
        }, 100);

        this.$refs.loadmore.onTopLoaded(id);
      }, 1500);
    }
  },
  mounted: function () {
    this.scrollToBottom();
    this.focusTxtContent();
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
a.link {
  color: #33df83;
  text-decoration: underline;
}

.mint-loadmore,
.mint-loadmore-content {
  height: 100%;
  padding-left: 5px;
  padding-right: 8px;
}
.chatlist {
  position: absolute;
  top: 60px;
  bottom: 48px;
  left: 0px;
  right: 0px;
  overflow-y: scroll;
  overflow-x: hidden;
  padding: 0 0 0 10px;
}

.chatlist-bottom {
  bottom: 48px;
  overflow: hidden;height: 640px;
}

.chatlist-bottom-collapse {
  bottom: 198px;
}

.chatlist ul {
  min-height: 300px;
  height: 100%;
  list-style-type: none;
  margin-block-start: 0px;
  margin-block-end: 0px;
  margin-inline-start: 0px;
  margin-inline-end: 0px;
  padding-inline-start: 0px;
  overflow-y: scroll;
}

.chatlist ul .chat-mine {
  text-align: right;
  padding-left: 0;
  padding-right: 60px;
}

.chatlist ul li {
  position: relative;
  /*font-size: 0;*/
  margin-bottom: 10px;
  padding-left: 60px;
  min-height: 68px;
}

.chat-mine .chat-user {
  left: auto;
  right: 3px;
}

.chat-user {
  position: absolute;
  left: 3px;top: 10px;
}

.chat-text,
.chat-user {
  display: inline-block;
  vertical-align: top;
  /*font-size: 14px;*/
}

.chat-user img {
  width: 40px;
  height: 40px;
  border-radius: 100%;
}

.time {
  width: 100%;
  text-align: left;
}

.chat-mine .time {
  text-align: right;
}

cite {
  left: auto;
  right: 60px;
  text-align: right;
}

cite {
  font-style: normal;
  line-height: 24px;
  font-size: 12px;
  white-space: nowrap;
  color: #999;
  text-align: left;
}

cite i {
  font-style: normal;
  padding-left: 5px;
  padding-right: 5px;
  font-size: 12px;
}

.chat-mine .chat-text {
  margin-left: 0;
  text-align: left;
  background-color: #33df83;
  color: #fff;
  float: right;
}

.chat-text {
  position: relative;
  float: left;
  line-height: 22px;
  /*margin-top: 25px;*/
  padding: 10px 15px;
  background-color: #eee;
  border-radius: 3px;
  color: #333;
  word-break: break-all;
  max-width: 462px\9;
  text-align: initial;
}

.chat-text,
.chat-user {
  display: inline-block;
  vertical-align: top;
  font-size: 14px;
}

.chat-text img {
  max-width: 100%;
  vertical-align: middle;
}

.chat-user {
  position: absolute;
  left: 3px;
}

.chat-text:after {
  content: "";
  position: absolute;
  left: -10px;
  top: 15px;
  width: 0;
  height: 0;
  border-style: solid dashed dashed;
  border-color: #eee transparent transparent;
  overflow: hidden;
  border-width: 10px;
}

.chat-mine .chat-text:after {
  left: auto;
  right: -10px;
  border-top-color: #33df83;
}

.foot {
  width: 100%;
  min-height: 48px;
  position: fixed;
  bottom: 0px;
  left: 0px;
  background-color: #f8f8f8;
}

.foot .con {
  position: absolute;
  left: 66px;
  right: 40px;
}

.foot .btn-plus {
  width: 28px;
  padding: 9px 3px;
  position: absolute;
  left: 0px;
  border-left: 1px solid #d9d9d9;
}

.foot .btn-plus i {
  font-size: 2em;
  color: #ccc;
}

.foot .btn-face {
  width: 28px;
  padding: 9px 3px 9px 0px;
  position: absolute;
  left: 35px;
  /*border-right: 1px solid #d9d9d9;*/
}

.foot .btn-face i {
  font-size: 2em;
  color: #d9d9d9;
}

.foot .selbox {
  height: 150px;
  margin-top: 48px;
  border-top: 1px solid #d9d9d9;
}

.show {
  display: block;
}

.hide {
  display: none;
}

.face-box {
  /* position: absolute; */
  /* top: 48px; */
  /* left: 0px; */
  /* right: 0px; */
  /* bottom: 0px; */
  padding: 15px 15px 0px 15px;
  overflow: hidden;
  width: 290px;
  margin: 0px auto;
  height: 135px;
}

.face-box li {
  width: 30px;
  float: left;
  padding: 6px 10px 0px 8px;
}

.btn {
  display: inline-block;
  vertical-align: top;
  font-size: 14px;
  line-height: 32px;
  margin-left: 5px;
  padding: 0 6px;
  background-color: #33df83;
  color: #fff;
  border-radius: 3px;
}

.btn-send {
  position: absolute;
  right: 0px;
  top: 8px;
}
</style>