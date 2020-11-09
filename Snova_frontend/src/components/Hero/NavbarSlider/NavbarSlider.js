import React from 'react'
// Images
import kyoto from './backgrounds/Kyoto - Japan.jpg'
import tenryuJiTemple from './backgrounds/Tenryu-ji Temple - Kyōto-shi - Japan.jpg'
import hakone from './backgrounds/Hakone - Japan.jpg'
import byodoInTemple from './backgrounds/Byodo-In Temple - Kaneohe - United States.jpg'
// Components
import HeroSlider, {
  Slide,
  MenuNav,
  OverlayContainer,
} from 'hero-slider'
import Navbar from '../UI/Navbar/Navbar'
import Wrapper from '../UI/Wrapper/Wrapper'
import Title from '../UI/Title/Title'
import Subtitle from '../UI/Subtitle/Subtitle'

const App = () => {
  const nextSlideHandler = React.useRef()
  const previousSlideHandler = React.useRef()

  return (
    <HeroSlider
      nextSlide={nextSlideHandler}
      previousSlide={previousSlideHandler}
      slidingAnimation='top_to_bottom'
      orientation='vertical'
      initialSlide={1}
      onBeforeChange={(previousSlide, nextSlide) => console.log('onBeforeChange', previousSlide, nextSlide)}
      onChange={(nextSlide) => console.log('onChange', nextSlide)}
      onAfterChange={(nextSlide) => console.log('onAfterChange', nextSlide)}
      style={{
        backgroundColor: '#000'
      }}
      settings={{
        slidingDuration: 400,
        slidingDelay: 100,
        shouldAutoplay: true,
        shouldDisplayButtons: false,
        autoplayDuration: 8000,
        height: '100vh'
      }}>
      <Navbar />
      <OverlayContainer>
        <Wrapper>
          <Title>
            Navbar Slider
          </Title>
          <Subtitle>
            Cool stuff.
          </Subtitle>
        </Wrapper>
      </OverlayContainer>

      <Slide
        shouldRenderMask
        navDescription='Kyoto - Japanini'
        background={{
          backgroundColor: '#6D9B98',
          backgroundImage: kyoto,
          backgroundAnimation: 'zoom'
        }} />

      <Slide
        shouldRenderMask
        navDescription='Tenryu-ji Temple - Kyōto-shi - Japan'
        background={{
          backgroundColor: '#8A8A8A',
          backgroundImage: tenryuJiTemple
        }} />

      <Slide
        shouldRenderMask
        navDescription='Hakone - Japan'
        background={{
          backgroundColor: '#EA2329',
          backgroundImage: hakone
        }} />

      <Slide
        shouldRenderMask
        navDescription='Byodo-In Temple - Kaneohe - United States'
        background={{
          backgroundColor: '#2D7791',
          backgroundImage: byodoInTemple
        }} />

      <MenuNav />
    </HeroSlider>
  )
}

export default App
