<template>
  <div class="IdiomInfo card">
    <DrawIdiom v-if="word.length>0" :word="word" :pinyin="pinyin"></DrawIdiom>
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
    }
  },
  props: ['inputword'],
  watch: {
    inputwordFun: function () {
      this.inputword = this.inputwordFun;
    },
    pinyinFun: function () {
      this.pinyin = this.pinyinFun;
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

    api.queryByWord({ word: this.inputword }).then(datas => {
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

  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.IdiomInfo{
    padding: 10px;
    margin: 20px 30px;
}
</style>
