<template>
  <div class="idiom-part">
    <div class="idiom-part-label">{{label}}</div>
    <div class="idiom-part-value">{{value}}</div>
  </div>
</template>

<script>
export default {
  name: 'IdiomPart',
  data() {
    return {

    }
  },
  props: ['label', 'value'],
  watch: {
    labelFun: function () {
      this.label = this.labelFun;
    },
    valueFun: function () {
      this.value = this.valueFun;
    },
  },
  mounted() {
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.idiom-part {
  margin: 10px 0 10px 0;
}
.idiom-part-label {
  font-size: 18px;color: #888;
}
.idiom-part-label::before {
  content: "【";
}
.idiom-part-label::after {
  content: "】";
}
.idiom-part-value {
  font-size: 21px;
  text-indent: 50px;
}
</style>
