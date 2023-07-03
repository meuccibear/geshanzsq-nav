<template>
  <el-carousel ref="banner" class="lz-banner" :interval="5000" arrow="always" :autoplay="autoplay">
    <el-carousel-item
      v-for="(item, i) in imgList"
      :key="i"
      :name="'banner' + i"
    >
      <el-image :src="item.imgUrl" fit="scale-down" @click.stop="imgClick(item,i)" />
    </el-carousel-item>
  </el-carousel>
</template>
<script>
import { watch, ref, nextTick } from 'vue'
export default {
  props: {
    // 展示的数据列表
    imgList: {
      default() {
        return []
      },
      type: Array
    },
    autoplay: {
      default() {
        return false
      },
      type: Boolean
    },
    activeNum: {
      default() {
        return 0
      },
      type: Number
    }
  },
  emits: ['imgChange'],
  setup(props, ctx) {
    const banner = ref(null)
    // 监听变化 改变图片的展示
    watch(() => props.activeNum, (n) => {
      // 要执行的方法
      nextTick(() => {
        banner.value.setActiveItem('banner' + n)
      })
    }, { immediate: true, deep: true })
    const imgClick = (item, i) => {
      ctx.emit('imgChange', item, i)
    }
    return { imgClick, banner }
  }
}
</script>

<style lang="scss">
.lz-banner {
  width: 800px;
  height: 488px;
  .el-carousel__container {
    width: 800px;
    height: 488px;
    img {
      display: block;
      width: 100%;
      height: 100%;
      //width: 800px;
      //height: 400px;
    }
  }
}
</style>
