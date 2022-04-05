<template>
  <div class="IdiomInfo card" v-if="word.length>0">
    <DrawIdiom :word="word" :pinyin="pinyin"></DrawIdiom>
    <div class="idiom-buttons-group no-touch">
      <div v-on:click.stop="doCollection">
        <svg v-if="!isCollection" t="1648478504193" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="1473" width="35" height="35">
          <path
            d="M240.154 934.54c11.134 7.636 24.193 11.516 37.266 11.516a66.176 66.176 0 0 0 31.297-7.84l203.258-109.464 203.3 109.463a66.374 66.374 0 0 0 31.296 7.841c13.06 0 26.12-3.88 37.294-11.516 20.19-13.948 30.518-37.854 26.474-61.706l-39.616-236.632 170.91-170.663c16.925-16.831 22.718-41.53 15.012-63.96-7.732-22.39-27.622-38.742-51.568-42.32l-233.149-34.686-101.361-210.389c-10.628-22.103-33.47-36.242-58.592-36.242-25.04 0-47.894 14.14-58.563 36.242l-101.336 210.39-233.16 34.684c-23.962 3.579-43.852 19.931-51.57 42.321-7.705 22.43-1.871 47.129 15.04 63.96l170.841 170.663-39.629 236.632c-3.99 23.852 6.323 47.758 26.556 61.706z"
            p-id="1474" fill="#707070"></path>
        </svg>
        <svg v-else-if="isCollection" t="1648480629309" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="3580" width="35" height="35">
          <path
            d="M240.154 934.54c11.134 7.636 24.193 11.516 37.266 11.516a66.176 66.176 0 0 0 31.297-7.84l203.258-109.464 203.3 109.463a66.374 66.374 0 0 0 31.296 7.841c13.06 0 26.12-3.88 37.294-11.516 20.19-13.948 30.518-37.854 26.474-61.706l-39.616-236.632 170.91-170.663c16.925-16.831 22.718-41.53 15.012-63.96-7.732-22.39-27.622-38.742-51.568-42.32l-233.149-34.686-101.361-210.389c-10.628-22.103-33.47-36.242-58.592-36.242-25.04 0-47.894 14.14-58.563 36.242l-101.336 210.39-233.16 34.684c-23.962 3.579-43.852 19.931-51.57 42.321-7.705 22.43-1.871 47.129 15.04 63.96l170.841 170.663-39.629 236.632c-3.99 23.852 6.323 47.758 26.556 61.706z"
            p-id="3581" fill="#d81e06"></path>
        </svg>
      </div>
      <div v-on:click.stop="doLike">
        <svg v-if="!isLike" t="1648478532126" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="1671" width="35" height="35">
          <path
            d="M707 121.9c-78.6 0-148.8 38.9-195.1 100-52.6-69.3-135.9-110-227-97.9C172.4 139 81.1 236.8 66.1 358.9c-10.8 87.6 16.3 168.3 66.2 226l11.5 12.5 207.4 225.5c88.7 96.5 232.6 96.5 321.3 0l207.4-225.5 11.5-12.5c42.5-49.2 68.5-115.2 68.5-188 0-151.9-113.3-275-252.9-275z"
            p-id="1672" fill="#707070"></path>
        </svg>
        <svg v-else-if="isLike" t="1648478532126" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="1671" width="35" height="35">
          <path
            d="M707 121.9c-78.6 0-148.8 38.9-195.1 100-52.6-69.3-135.9-110-227-97.9C172.4 139 81.1 236.8 66.1 358.9c-10.8 87.6 16.3 168.3 66.2 226l11.5 12.5 207.4 225.5c88.7 96.5 232.6 96.5 321.3 0l207.4-225.5 11.5-12.5c42.5-49.2 68.5-115.2 68.5-188 0-151.9-113.3-275-252.9-275z"
            p-id="1672" fill="#d81e06"></path>
        </svg>
      </div>
      <div v-on:click.stop="doFeedback">
        <svg t="1648478601994" class="icon" viewBox="0 0 1138 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2667" width="35" height="35">
          <path
            d="M1055.738 57.594c-45.439-36.351-154.492-27.262-304.439 86.333-213.562 159.036-308.983 368.052-445.298 572.527-22.719 31.807 13.632 49.983 40.895 36.351l86.333-49.983c13.632-4.544 18.175-4.544 13.632-27.262-9.088-68.158 18.176-131.772 59.07-186.298 149.947 63.614 331.702 27.262 395.317-154.492 81.789-18.176 159.036-109.053 172.667-172.666 13.632-45.439 9.088-86.333-18.175-104.509z m-913.316 658.86c122.684 213.562 390.773 286.263 604.333 163.58 140.859-81.789 218.105-227.193 222.649-377.14 0-49.983-59.07-45.439-59.07 0 0 131.772-68.158 254.457-190.842 327.158-186.298 104.509-422.579 40.895-527.088-140.859-109.053-186.298-45.439-422.579 140.859-527.088 99.965-59.07 222.649-68.158 322.614-27.262 40.895 13.632 59.07-40.895 18.175-54.527C555.911 39.421 424.141 43.965 306 112.123 92.438 234.807 19.737 507.44 142.42 716.456z"
            p-id="2668" fill="#707070"></path>
        </svg>
      </div>
    </div>
    <IdiomPart v-for="(item,i) in idiomParts" :key="i" :label="item.label" :value="item.value"></IdiomPart>
  </div>
</template>

<script>
import DrawIdiom from './DrawIdiom'
import IdiomPart from './IdiomPart'
import api from '../../http/api.js'
export default {
  name: 'IdiomInfo',
  components: {
    DrawIdiom,
    IdiomPart,
  },
  data() {
    return {
      word: '',
      pinyin: [],
      idiomParts: [],
      isCollection: false,
      isLike: false,
    }
  },
  props: ['inputword'],
  watch: {
    inputwordFun: function () {
      this.inputword = this.inputwordFun;
      debugger
      searchWord(this.inputword);
    },
    pinyinFun: function () {
      this.pinyin = this.pinyinFun;
      //   searchWord(this.inputword);
    },
  },
  beforeCreate: function () {
    // 创建前
  },
  created: function () {
    // 创建完毕
  },
  beforeMount: function () {
    // 挂载前
  },
  mounted: function () {
    // 挂载结束
    searchWord(this.inputword);
  },
  beforeUpdate: function () {
    // 更新前
  },
  updated: function () {
    // 更新完成
  },
  beforeDestroy: function () {
    // 销毁前
  },
  destroyed: function () {
    // 销毁完成
  },
  methods: {
    doCollection: function () { this.isCollection = !this.isCollection; console.log(this.isCollection ? '收藏' : '取消收藏'); },
    doLike: function () {
      this.isLike = !this.isLike; console.log(this.isLike ? '喜欢' : '取关');
    },
    doFeedback: function () { console.log('反馈'); },
    searchWord: function (word) {
      api.queryByWord({ word: word })
        // api.randomQuery({ limit: 1 })
        .then(datas => {
          //   console.log(datas)
          if (datas && Array.isArray(datas) && datas.length > 0) {
            var data = datas[0];
            this.word = data.word;
            this.pinyin = data.pinyin.replace(/，/ig, " ").split(' ');

            // abbreviation: "zsms"
            // explanation: "原指玩弄手法欺骗人。后用来比喻常常变卦，反复无常。"
            // firstWordPinyin: "zhao"
            // firstchar: "朝"
            // id: 3506
            // lastWordPinyin: "si"
            // lastchar: "四"
            // length: 4
            // pinyin: "zhāo sān mù sì"
            // source: "《庄子·齐物论》：“狙公赋芧，曰：‘朝三而暮四。’众狙皆怒。曰：‘然则朝四而暮三。’众狙皆悦。名实未亏而喜怒为用，亦因是也。”"
            // tPintin: "zhao san mu si"
            // word: "朝三暮四"

            this.idiomParts.push({
              label: "成语", value: data.word
            });
            this.idiomParts.push({
              label: "长度", value: data.length
            });
            this.idiomParts.push({
              label: "拼音", value: data.pinyin
            });
            this.idiomParts.push({
              label: "去调拼音", value: data.tPinyin
            });
            this.idiomParts.push({
              label: "拼音缩写", value: data.abbreviation
            });
            this.idiomParts.push({
              label: "释义", value: data.explanation
            });
            this.idiomParts.push({
              label: "出处", value: data.source
            });
          }
        });
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.IdiomInfo {
  padding: 10px;
  margin: 20px auto;
  overflow-y: scroll;
  max-height: 85%;
  max-width: 700px;
}
.idiom-buttons-group {
  width: fit-content;
  margin: 0 auto;
}
.idiom-buttons-group > div {
  display: inline-block;
  cursor: pointer;
}
</style>
