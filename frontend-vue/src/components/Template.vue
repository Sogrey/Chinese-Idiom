<template>
  <div class="template">
  </div>
</template>

<script>
export default {
  name: 'Template',
  data() {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  }, beforeCreate: function () {
    console.group('beforeCreate 创建前状态-->');
    var state = {
      'el': this.$el,
      'data': this.$data,
      'message': this.message
    }
    console.log(this.$el);
    console.log(state);
  },
  created: function () {
    console.group('created 创建完毕状态-->');
    var state = {
      'el': this.$el,
      'data': this.$data,
      'message': this.message
    }
    console.log(this.$el);
    console.log(state);
  },
  beforeMount: function () {
    console.group('beforeMount 挂载前状态-->');
    var state = {
      'el': this.$el,
      'data': this.$data,
      'message': this.message
    }
    console.log(this.$el);
    console.log(state);
  },
  mounted: function () {
    console.group('mounted 挂载结束状态-->');
    var state = {
      'el': this.$el,
      'data': this.$data,
      'message': this.message
    }
    console.log(this.$el);
    console.log(state);
  },
  beforeUpdate: function () {
    console.group('beforeUpdate 更新前状态-->');
    var state = {
      'el': this.$el,
      'data': this.$data,
      'message': this.message
    }
    console.log(this.$el);
    console.log(state);
  },
  updated: function () {
    console.group('updated 更新完成状态-->');
    var state = {
      'el': this.$el,
      'data': this.$data,
      'message': this.message
    }
    console.log(this.$el);
    console.log(state);
  },
  beforeDestroy: function () {
    console.group('beforeDestroy 销毁前状态-->');
    var state = {
      'el': this.$el,
      'data': this.$data,
      'message': this.message
    }
    console.log(this.$el);
    console.log(state);
  },
  destroyed: function () {
    console.group('destroyed 销毁完成状态-->');
    var state = {
      'el': this.$el,
      'data': this.$data,
      'message': this.message
    }
    console.log(this.$el);
    console.log(state);
  },
  methods: {
    clickfun() {
    //   myVue.$destroy()
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
