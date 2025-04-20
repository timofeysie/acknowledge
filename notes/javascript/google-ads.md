# Google Ads Implementation Guide

## Key Technical Considerations

### 1. Performance Impact

- Ads can affect Core Web Vitals
- Consider lazy loading ads below the fold
- Implement with proper timing to not block main content loading
- Use appropriate `data-loading` attributes:

```html
<ins class="adsbygoogle"
     data-ad-client="ca-pub-XXXXXXXXXXXXXXXX"
     data-ad-slot="XXXXXXXXXX"
     data-ad-format="auto"
     data-full-width-responsive="true"
     data-loading="lazy"></ins>
```

### 2. Placement Best Practices

- Avoid too many ads above the fold
- Maintain adequate spacing between ads
- Follow Google's policies on ad density:
  - Maximum of 1 anchor/overlay ad per page
  - Maximum of 3 AdSense for content units per page
  - Minimum spacing of 150px between ad units

### 3. Responsive Design

```typescript
const ResponsiveAdUnit: React.FC = () => {
  useEffect(() => {
    // Wait for Google Ads to be ready
    (window.adsbygoogle = window.adsbygoogle || []).push({});
  }, []);

  return (
    <ins className="adsbygoogle"
         style={{ display: 'block' }}
         data-ad-client="ca-pub-XXXXXXXXXXXXXXXX"
         data-ad-slot="XXXXXXXXXX"
         data-ad-format="auto"
         data-full-width-responsive="true" />
  );
};
```

### 4. Error Handling

```typescript
const AdUnit: React.FC = () => {
  useEffect(() => {
    try {
      (window.adsbygoogle = window.adsbygoogle || []).push({});
    } catch (error) {
      console.error('Ad loading failed:', error);
      // Implement fallback content or error reporting
    }
  }, []);

  return (/* Ad component */);
};
```

## Compliance Requirements

### 1. Privacy and Consent

- Implement cookie consent for EU users (GDPR)
- Include ads in your privacy policy
- Add appropriate disclosures
- Consider implementing a Consent Management Platform (CMP)

### 2. Content Policies

- No adult content
- No illegal content
- No copyright infringement
- No misleading content
- No malicious code

### 3. Technical Requirements

- Valid HTML
- Mobile-friendly design
- Adequate content-to-ad ratio
- No clicking own ads
- No artificial inflation of impressions

### Testing

- Test ads in different viewports
- Verify lazy loading works
- Check page speed impact
- Validate ad placements
- Test with ad blockers
- Verify responsive behavior

### Monitoring

- Set up performance monitoring
- Track ad viewability
- Monitor revenue metrics
- Check for policy violations
- Track user experience metrics

## Best Practices for React Implementation

### 1. Create a Reusable Ad Component

```typescript
interface GoogleAdProps {
  adSlot: string;
  adFormat?: string;
  fullWidthResponsive?: boolean;
  style?: React.CSSProperties;
}

const GoogleAd: React.FC<GoogleAdProps> = ({
  adSlot,
  adFormat = 'auto',
  fullWidthResponsive = true,
  style
}) => {
  useEffect(() => {
    try {
      (window.adsbygoogle = window.adsbygoogle || []).push({});
    } catch (error) {
      console.error('Ad loading failed:', error);
    }
  }, []);

  return (
    <ins
      className="adsbygoogle"
      style={{ display: 'block', ...style }}
      data-ad-client="ca-pub-XXXXXXXXXXXXXXXX"
      data-ad-slot={adSlot}
      data-ad-format={adFormat}
      data-full-width-responsive={fullWidthResponsive}
    />
  );
};
```

### 2. Implement Lazy Loading

This method will use the [IntersectionObserver](https://developer.mozilla.org/en-US/docs/Web/API/Intersection_Observer_API) API to detect when the ad is visible in the viewport and then load the ad.

```typescript
const LazyGoogleAd: React.FC<GoogleAdProps> = (props) => {
  const adRef = useRef<HTMLDivElement>(null);
  const [isVisible, setIsVisible] = useState(false);

  useEffect(() => {
    const observer = new IntersectionObserver(
      ([entry]) => {
        if (entry.isIntersecting) {
          setIsVisible(true);
          observer.disconnect();
        }
      },
      { threshold: 0.1 }
    );

    if (adRef.current) {
      observer.observe(adRef.current);
    }
    // stop watching for changes when the component is unmounted or 
    // a new element is passed to the hook to improve performance
    return () => observer.disconnect();
  }, []);

  return (
    <div ref={adRef}>
      {isVisible && <GoogleAd {...props} />}
    </div>
  );
};
```

The array brackets ([entry]) in the IntersectionObserver callback function above is used for array destructuring.

The IntersectionObserver callback receives an array of IntersectionObserverEntry objects, even when observing a single element.

The array brackets are used to destructure this array and extract the first entry directly.

An example without destructuring would be this:

```javascript
const observer = new IntersectionObserver(entries => {
  const entry = entries[0];
  ...
```

### 3. Handle Ad Blocking

```typescript
const AdWithFallback: React.FC<GoogleAdProps> = (props) => {
  const [isBlocked, setIsBlocked] = useState(false);

  useEffect(() => {
    const checkAdBlocker = async () => {
      try {
        await fetch('https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js');
      } catch {
        setIsBlocked(true);
      }
    };

    checkAdBlocker();
  }, []);

  if (isBlocked) {
    return <FallbackContent />;
  }

  return <GoogleAd {...props} />;
};
```

## Performance Optimization Tips

1. Defer ad loading until after critical content
2. Use appropriate ad sizes for different viewports
3. Implement proper error boundaries
4. Monitor and optimize ad viewability
5. Balance ad revenue with user experience

## Analytics Integration

Consider implementing:

- Google Analytics integration
- Custom event tracking
- Performance monitoring
- Revenue tracking
- User engagement metrics
