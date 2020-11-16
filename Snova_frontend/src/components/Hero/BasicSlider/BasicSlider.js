import React from 'react';

// Images
import bogliasco from 'assets/img/bg-1.jpg';
import countyClare from 'assets/img/bg-2.jpg';
import craterRock from 'assets/img/bg-3.jpg';


// Components
import HeroSlider, {
  Slide,
  Nav,
  OverlayContainer,
} from 'hero-slider'
//import StyledSlide from './StyledSlide';
import Wrapper from '../UI/Wrapper/Wrapper';
import Title from '../UI/Title/Title';
import Subtitle from '../UI/Subtitle/Subtitle';

const App = () => {
  const nextSlideHandler = React.useRef()
  const previousSlideHandler = React.useRef()

  return (
    <HeroSlider
      nextSlide={nextSlideHandler}
      previousSlide={previousSlideHandler}
      slidingAnimation='left_to_right'
      orientation='horizontal'
      initialSlide={1}
      // onBeforeChange={(previousSlide, nextSlide) => console.log('onBeforeChange', previousSlide, nextSlide)}
      onChange={(nextSlide) => console.log('onChange', nextSlide)}
      // onAfterChange={(nextSlide) => console.log('onAfterChange', nextSlide)}
      style={{
        backgroundColor: 'rgba(0, 0, 0, 0.33)',
        color: 'rgba(255, 255, 255, 0.75)'
      }}
      settings={{
        slidingDuration: 250,
        slidingDelay: 100,
        shouldAutoplay: true,
        shouldDisplayButtons: false,
        shouldSlideOnArrowKeypress: true,
        autoplayDuration: 5000,
        height: '100vh'
      }}>
      <OverlayContainer>
        <Wrapper>
          <Title>
          {/* <img src={require('assets/img/logo.png')} /> */}
          <p>SNOVA BOOKINGS</p>
          Enjoy unique experiences
          
          </Title>
          <Subtitle>
            
          </Subtitle>
        </Wrapper>
      </OverlayContainer>

   

      <Slide
       
        navDescription='Bogliasco - Italy'
        background={{
          backgroundImage: bogliasco,
          backgroundColor: '#6D9B98',         
          maskBackgroundBlendMode: 'luminosity',
          backgroundAttachment: 'fixed',
          backgroundAnimation: 'zoom'
        }} />

      <Slide
        
        navDescription='County Clare - Ireland'
        background={{
          backgroundImage: countyClare,
          backgroundColor: '#6D9B98',         
          maskBackgroundBlendMode: 'luminosity',
          backgroundAttachment: 'fixed',
          backgroundAnimation: 'zoom'
        }} />

      <Slide
        
        navDescription='Crater Rock, OR - United States'
        background={{
          backgroundImage: craterRock,
          backgroundColor: '#6D9B98',         
          maskBackgroundBlendMode: 'luminosity',
          backgroundAttachment: 'fixed',
          backgroundAnimation: 'zoom'
        }} />

      <Nav />
    </HeroSlider>
  )
}

export default App
