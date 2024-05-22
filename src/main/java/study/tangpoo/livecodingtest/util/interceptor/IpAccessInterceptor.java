package study.tangpoo.livecodingtest.util.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import study.tangpoo.livecodingtest.repository.WhiteIpRepository;
import study.tangpoo.livecodingtest.util.ClientIp;

@Component
@RequiredArgsConstructor
@Slf4j
public class IpAccessInterceptor implements HandlerInterceptor {

    private final WhiteIpRepository whiteIpRepository;

    @Override
    public boolean preHandle(HttpServletRequest request,
        HttpServletResponse response, Object handler) throws Exception {
        String clientIp = ClientIp.getClientIP(request);
        if (clientIp.equals("127.0.0.1")) {
            return true;
        }

        if (!whiteIpRepository.findByAccessIp(clientIp).isPresent()) {
            log.warn("Forbidden access, URI: {}, IP: {}", request.getRequestURI(), clientIp);
            response.sendError(403, "IP Forbidden");
            return false;
        }

        return true;
    }
}
