# Using iFrames in React/TypeScript

This guide covers best practices for implementing ads using iFrames in a React/TypeScript context.

## Basic Ad Component

Here's a reusable Ad Component with TypeScript typing:

```typescript
interface AdProps {
  adUrl: string;
  width?: number;
  height?: number;
  title?: string;
  className?: string;
  onLoad?: () => void;
  onError?: (error: Error) => void;
}

const AdFrame: React.FC<AdProps> = ({
  adUrl,
  width = 300,
  height = 250,
  title = "Advertisement",
  className,
  onLoad,
  onError
}) => {
  const iframeRef = useRef<HTMLIFrameElement>(null);

  useEffect(() => {
    const handleLoad = () => {
      onLoad?.();
    };

    const handleError = (error: ErrorEvent) => {
      onError?.(error.error);
    };

    const iframe = iframeRef.current;
    if (iframe) {
      iframe.addEventListener('load', handleLoad);
      iframe.addEventListener('error', handleError);
    }

    return () => {
      if (iframe) {
        iframe.removeEventListener('load', handleLoad);
        iframe.removeEventListener('error', handleError);
      }
    };
  }, [onLoad, onError]);

  return (
    <iframe
      ref={iframeRef}
      src={adUrl}
      width={width}
      height={height}
      title={title}
      className={className}
      frameBorder="0"
      scrolling="no"
      sandbox="allow-scripts allow-same-origin allow-popups"
    />
  );
};
```

## Key Best Practices

### 1. Security

- Use the `sandbox` attribute with specific permissions
- Only load ads from trusted sources
- Implement Content-Security-Policy headers

### 2. Performance

- Lazy load ads below the fold
- Specify width and height to prevent layout shifts
- Use `loading="lazy"` attribute for below-fold ads

### 3. Error Handling

Implement an error boundary:

```typescript
const AdWithErrorBoundary: React.FC<AdProps> = (props) => {
  return (
    <ErrorBoundary fallback={<div>Ad failed to load</div>}>
      <AdFrame {...props} />
    </ErrorBoundary>
  );
};
```

### 4. Usage Example

```typescript
const HomePage: React.FC = () => {
  const handleAdLoad = () => {
    console.log('Ad loaded successfully');
  };

  const handleAdError = (error: Error) => {
    console.error('Ad failed to load:', error);
  };

  return (
    <AdFrame
      adUrl="https://trusted-ad-server.com/ad"
      width={300}
      height={250}
      onLoad={handleAdLoad}
      onError={handleAdError}
    />
  );
};
```

### 5. Lazy Loading Implementation

```typescript
const LazyAdFrame = lazy(() => import('./AdFrame'));

const PageWithLazyAd: React.FC = () => {
  return (
    <Suspense fallback={<div>Loading ad...</div>}>
      <LazyAdFrame adUrl="https://trusted-ad-server.com/ad" />
    </Suspense>
  );
};
```

## Additional Considerations

### Accessibility

- Use proper ARIA attributes
- Provide meaningful iframe titles
- Implement skip-ad functionality where appropriate

### Analytics

- Track ad impressions
- Monitor loading performance
- Implement error tracking

### Responsive Design

```typescript
const ResponsiveAd: React.FC<AdProps> = (props) => {
  const [dimensions, setDimensions] = useState({ width: 300, height: 250 });

  useEffect(() => {
    const handleResize = () => {
      // Adjust dimensions based on viewport
      const newDimensions = calculateAdDimensions(window.innerWidth);
      setDimensions(newDimensions);
    };

    window.addEventListener('resize', handleResize);
    return () => window.removeEventListener('resize', handleResize);
  }, []);

  return <AdFrame {...props} {...dimensions} />;
};
```

### Ad Blocking Detection

```typescript
const useAdBlockDetection = () => {
  const [isBlocked, setIsBlocked] = useState(false);

  useEffect(() => {
    const checkAdBlocker = async () => {
      try {
        // Attempt to load a test ad
        const response = await fetch('https://your-ad-server.com/test');
        setIsBlocked(!response.ok);
      } catch {
        setIsBlocked(true);
      }
    };

    checkAdBlocker();
  }, []);

  return isBlocked;
};
```

## Important Reminders

- Always comply with ad network policies
- Follow privacy regulations
- Implement proper ad refresh mechanisms
- Clean up event listeners and subscriptions on component unmount

## Other options

Since iframe is a nested full-fledged document, it does not expect children.

ReactPortal can be used to render something virtually at one location and actually render at another.

```js
function IFrame({ children }) {
  const [ref, setRef] = useState();
  const container = ref?.contentWindow?.document?.body;

  return (
    <iframe ref={setRef}>
      {container && createPortal(children, container)}
    </iframe>
  );
}

function RenderingInIFrame() {
  return (
    <IFrame>
      <MyComponent />
    </IFrame>
  );
}
```

[Source](https://dev.to/graftini/rendering-in-an-iframe-in-a-react-app-2boa)

## An expandable iframe that opens into a modal carousel

```js
interface ExpandableAdProps extends AdProps {
  carouselImages: string[];
  modalWidth?: number;
  modalHeight?: number;
}

const ExpandableAdFrame: React.FC<ExpandableAdProps> = ({
  carouselImages,
  modalWidth = 800,
  modalHeight = 600,
  ...adProps
}) => {
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [currentSlide, setCurrentSlide] = useState(0);

  const handleAdClick = () => {
    setIsModalOpen(true);
  };

  const handleClose = () => {
    setIsModalOpen(false);
    setCurrentSlide(0);
  };

  const nextSlide = () => {
    setCurrentSlide((prev) => (prev + 1) % carouselImages.length);
  };

  const prevSlide = () => {
    setCurrentSlide((prev) => 
      prev === 0 ? carouselImages.length - 1 : prev - 1
    );
  };

  return (
    <>
      <div 
        onClick={handleAdClick} 
        style={{ cursor: 'pointer' }}
      >
        <AdFrame {...adProps} />
      </div>

      {isModalOpen && (
        <div className="modal-overlay" 
          style={{
            position: 'fixed',
            top: 0,
            left: 0,
            right: 0,
            bottom: 0,
            backgroundColor: 'rgba(0, 0, 0, 0.75)',
            display: 'flex',
            justifyContent: 'center',
            alignItems: 'center',
            zIndex: 1000
          }}
        >
          <div className="modal-content"
            style={{
              width: modalWidth,
              height: modalHeight,
              backgroundColor: 'white',
              borderRadius: '8px',
              position: 'relative'
            }}
          >
            <button 
              onClick={handleClose}
              style={{
                position: 'absolute',
                right: '10px',
                top: '10px',
                zIndex: 1
              }}
            >
              ✕
            </button>

            <div className="carousel"
              style={{
                height: '100%',
                position: 'relative',
                overflow: 'hidden'
              }}
            >
              <div 
                style={{
                  display: 'flex',
                  transform: `translateX(-${currentSlide * 100}%)`,
                  transition: 'transform 0.3s ease-in-out'
                }}
              >
                {carouselImages.map((image, index) => (
                  <img
                    key={index}
                    src={image}
                    alt={`Slide ${index + 1}`}
                    style={{
                      width: '100%',
                      height: '100%',
                      flexShrink: 0,
                      objectFit: 'contain'
                    }}
                  />
                ))}
              </div>

              <button 
                onClick={prevSlide}
                style={{
                  position: 'absolute',
                  left: '10px',
                  top: '50%',
                  transform: 'translateY(-50%)'
                }}
              >
                ←
              </button>

              <button 
                onClick={nextSlide}
                style={{
                  position: 'absolute',
                  right: '10px',
                  top: '50%',
                  transform: 'translateY(-50%)'
                }}
              >
                →
              </button>
            </div>
          </div>
        </div>
      )}
    </>
  );
};
```

For better styling and animations, you might want to use a CSS-in-JS solution or separate CSS file. Here's an example with styled-components:

```js
import styled from 'styled-components';

const ModalOverlay = styled.div`
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(0, 0, 0, 0.75);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1000;
  animation: fadeIn 0.3s ease-in-out;

  @keyframes fadeIn {
    from { opacity: 0; }
    to { opacity: 1; }
  }
`;

const ModalContent = styled.div`
  width: ${props => props.width}px;
  height: ${props => props.height}px;
  background-color: white;
  border-radius: 8px;
  position: relative;
  animation: scaleIn 0.3s ease-in-out;

  @keyframes scaleIn {
    from {
      transform: scale(0.8);
      opacity: 0;
    }
    to {
      transform: scale(1);
      opacity: 1;
    }
  }
`;

const CarouselButton = styled.button`
  background: rgba(255, 255, 255, 0.8);
  border: none;
  border-radius: 50%;
  width: 40px;
  height: 40px;
  cursor: pointer;
  display: flex;
  align-items: center;
  justify-content: center;
  transition: background-color 0.2s;

  &:hover {
    background: rgba(255, 255, 255, 1);
  }
`;
```
