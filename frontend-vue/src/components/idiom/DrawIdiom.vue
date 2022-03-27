<template>
  <div id="idiom-draw" class="no-touch">
    <div id="idiom-pinyin">
      <label v-for="(item,i) in pinyin" :key="i">{{item}}</label>
    </div>
    <div id="idiom-hanzi"></div>
  </div>
</template>

<script>
import cnchar from 'cnchar'
import draw from 'cnchar-draw'
export default {
  name: 'DrawIdiom',
  data() {
    return {
    }
  },
  props: ['word', 'pinyin'],
  watch: {
    wordFun: function () {
      this.word = this.wordFun;
    },
    pinyinFun: function () {
      this.pinyin = this.pinyinFun;
    },
  },
  mounted() {
    var draw_options = {
      el: document.getElementById('idiom-hanzi'),// 绘制的容器，支持id和dom，若是不填，会在body后append一个dom作为容器
      type: "animation", // 绘制模式，默认为normal
      //draw 的参数比较繁多，首先需要理解的是，draw 分为四种绘制模式：
      // normal: 常规绘制
      // animation: 带有绘制动画，支持连续绘制、同时绘制、循环绘制
      // stroke: 按汉字笔顺单步绘制
      // test: 测试模式，用户可以在容器内绘制汉字，cnchar-draw会检测是否绘制正确

      style: { // 样式类
        showOutline: true,//: true,
        showCharacter: true,//: true,
        currentColor: '#b44',//: '#b44', // 仅在stroke模式下有效
        length: 60,//: 60,
        padding: 5,//: 5, // 数值, 默认 20。 画布的汉字和边缘之间的填充
        outlineColor: '#ddd',//: '#ddd', // 十六进制字符, 默认 '#DDD'。
        strokeColor: '#222',//: '#555', // 十六进制字符, 默认 '#555'。绘制每个笔划的颜色。
        radicalColor: null,//: null, // 十六进制字符, 默认 null。 如果存在偏旁部首数据，则在笔划中绘制偏旁部首的颜色。 如果没有设置，激光将绘制与其他笔划相同的颜色。
        strokeFadeDuration: 400, //400
      },
      line: { // 背景线条类
        lineStraight: true,// : true,
        lineCross: true,// : true,
        lineWidth: 1,// : 1,
        lineColor: '#722',// : '#ddd',
        lineDash: true,// : true,
        border: true,// : true,
        borderWidth: 1,// : 1,
        borderColor: '#7225',// : '#ccc',
        borderDash: false,// : false,
      },
      animation: {
        strokeAnimationSpeed: 1, // 数值, 默认 1。 绘制每个笔划的速度必须大于0。增加此数字可以更快地绘制笔划，减少绘制笔划的速度更慢。
        delayBetweenStrokes: 100, // 数值, 默认 1000。 动画进行中每个笔画之间的间隔时间（以毫秒为单位）。
        delayBetweenLoops: 20, // 数值, 默认 2000。 循环动画时每个动画循环之间的时间（以毫秒为单位）。
        autoAnimate: true,
        animateComplete: () => { console.log('书写完成'); },
        stepByStep: true,
        loopAnimate: false,
      },
      test: {
        strokeHighlightSpeed: 20, // 数值, 默认 20。 在测验中给出提示时突出显示每个笔划的速度必须大于0。增加此数字以突出显示更快，减少以突出显示更慢。
        highlightColor: '#aaf', // 十六进制字符, 默认 '#AAF'。 用于在测验中突出显示的颜色。
        drawingColor: '#333', // 十六进制字符, 默认 '#333'。 测验期间绘制的线条颜色。
        drawingWidth: 4, // 数值, 默认 4。 进行测验时绘制的线条宽度。
        showHintAfterMisses: 3, // 整数, 默认 3 中风高亮提示之前的未命中数被给予用户。 设置为 false 以禁用。 创建测验时也可以设置此项。
        highlightOnComplete: true, // 布尔值, 默认 true。 控制当用户完成绘制整个字符时，测验是否会短暂突出显示字符。 创建测验时也可以设置此项。
        highlightCompleteColor: null, // 十六进制字符, 默认 null。 在测验中突出显示字符时使用的颜色。 如果未设置，则将使用highlightColor。 仅当highlightOnComplete为true时才相关。
        onTestStatus: ({ index, status, data }) => {
          console.log(index, status, data);
        }
      }
    }

    if (this.word && this.word.length > 0)
      cnchar.draw(this.word, draw_options);
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#idiom-draw {
  transform: scale(1, 1);
}
#idiom-pinyin {
  text-align-last: center;
  width: auto;
}
#idiom-pinyin > label {
  width: 62px;
  display: inline-block;
  font-size: 18px;
}
#idiom-hanzi {
  width: auto;
  text-align-last: center;
}
</style>
